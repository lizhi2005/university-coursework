import argparse
import os
import re
import requests
from collections import defaultdict
from concurrent.futures import ProcessPoolExecutor, as_completed
import multiprocessing

# ---------------------- 全局配置 ----------------------
# 停用词
STOP_WORDS = set([
    "the", "a", "an", "and", "or", "but", "is", "are", "was", "were",
    "in", "on", "at", "to", "for", "of", "with", "by", "i", "you",
    "he", "she", "it", "we", "they", "me", "him", "her", "this", "that"
])

# 单词标准化
def normalize(word):
    w = word.lower()
    irregular = {
        "took": "take", "taken": "take", "taking": "take", "takes": "take",
        "was": "be", "were": "be", "been": "be",
        "had": "have", "has": "have",
        "went": "go", "gone": "go", "going": "go"
    }
    if w in irregular:
        return irregular[w]
    if w.endswith("ing"):
        return w[:-3]
    elif w.endswith("ed"):
        return w[:-2]
    elif w.endswith("s"):
        return w[:-1]
    return w

# 下载单个文档
def download_book(url):
    try:
        headers = {"User-Agent": "Mozilla/5.0"}
        res = requests.get(url, timeout=15, headers=headers)
        res.encoding = "utf-8"
        return res.text
    except Exception as e:
        print(f"【失败】下载失败：{url}")
        return None

# 单个文档构建局部索引
def process_single_doc(url):
    text = download_book(url)
    if not text:
        return (url, {})
    words = re.findall(r"[a-zA-Z]+", text)
    doc_word_count = defaultdict(int)
    for w in words:
        nw = normalize(w)
        if len(nw) >= 2 and nw not in STOP_WORDS:
            doc_word_count[nw] += 1
    return (url, doc_word_count)

# ---------------------- 主逻辑 ----------------------
def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("--url_file", required=True, help="URL列表文件路径")
    args = parser.parse_args()

    # 1. 读取URL
    if not os.path.exists(args.url_file):
        print(f"Error: File '{args.url_file}' does not exist.")
        return
    with open(args.url_file, "r", encoding="utf-8") as f:
        urls = [line.strip() for line in f if line.strip()]
    if not urls:
        print("Error: No URLs found in the file.")
        return

    # 2. 多进程构建索引
    print("Building index now…")
    # 索引结构：{url: {word: count, ...}, ...}
    index = {}
    with ProcessPoolExecutor(max_workers=multiprocessing.cpu_count()) as executor:
        futures = [executor.submit(process_single_doc, url) for url in urls]
        for future in as_completed(futures):
            url, doc_dict = future.result()
            if doc_dict:
                index[url] = doc_dict

    # 3. 索引统计
    all_words = set()
    for d in index.values():
        all_words.update(d.keys())
    print("Index built successfully!")
    print(f"Total documents indexed: {len(index)}")
    print(f"Total unique words: {len(all_words)}")
    print("\nIndex built, ready to search.")

    # 4. 搜索循环
    while True:
        print("\nPlease enter text to search, separated by space:")
        query = input().strip()
        if query.lower() == "exit":
            print("Goodbye!")
            break
        if not query:
            print("Error: Search text cannot be empty. Please try again.")
            continue

        # 处理查询词
        raw_terms = query.split()
        valid_terms = []
        for term in raw_terms:
            nt = normalize(term)
            if len(nt) >= 2 and nt not in STOP_WORDS:
                valid_terms.append(nt)
        if not valid_terms:
            print("Error: No valid search terms (all are stop words or too short).")
            continue

        # 输入K
        print("Please enter the number of documents you want:")
        k_str = input().strip()
        try:
            k = int(k_str)
            if k <= 0:
                print("Error: Number of documents must be positive. Using default value 10.")
                k = 10
        except ValueError:
            print("Error: Please enter a valid positive integer. Using default value 10.")
            k = 10

        # 匹配文档：包含所有有效词
        candidates = []
        for url, word_dict in index.items():
            # 检查是否包含所有查询词
            if all(t in word_dict for t in valid_terms):
                total = sum(word_dict[t] for t in valid_terms)
                detail = {t: word_dict[t] for t in valid_terms}
                candidates.append((url, total, detail))

        if not candidates:
            print("No documents found containing all search terms.")
            continue

        # 排序并取Top K
        candidates.sort(key=lambda x: x[1], reverse=True)
        top_k = candidates[:k]

        # 输出
        print("\nSearch results:")
        for idx, (url, total, detail) in enumerate(top_k, 1):
            # 从url提取简单文件名
            fname = url.split("/")[-1]
            parts = [f"{t}({c})" for t, c in detail.items()]
            print(f"{idx}. {fname}")
            print(f"   keyword count: {' | '.join(parts)} | total: {total}\n")

if __name__ == "__main__":
    # Windows必须加这一行，防止子进程无限重启
    multiprocessing.freeze_support()
    main()