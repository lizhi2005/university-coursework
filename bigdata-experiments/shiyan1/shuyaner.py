import argparse
import requests
import re
from collections import defaultdict
from concurrent.futures import ThreadPoolExecutor
import threading

# 全局锁，保证线程安全
lock = threading.Lock()
# 全局总词频字典
total_word_freq = defaultdict(int)

# 下载书籍（保留你原来的写法）
def download_book(url):
    try:
        headers = {"User-Agent": "Mozilla/5.0"}
        res = requests.get(url, timeout=15)
        res.encoding = "utf-8"
        return res.text
    except:
        print(f"【失败】下载失败：{url}")
        return None

# 单词标准化（完全保留你原来的逻辑）
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
    if w.endswith("ed"):
        return w[:-2]
    if w.endswith("s"):
        return w[:-1]
    return w

# 处理单个URL（多线程执行）
def process_one_url(url):
    text = download_book(url)
    if not text:
        return

    # 分词
    words = re.findall(r"[a-zA-Z]+", text.lower())
    # 本地统计
    local_freq = defaultdict(int)
    for w in words:
        norm_w = normalize(w)
        local_freq[norm_w] += 1

    # 加锁 → 合并到全局
    with lock:
        for word, cnt in local_freq.items():
            total_word_freq[word] += cnt

# 主程序
def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("--url_file_path", required=True, help="URL列表文件路径")
    parser.add_argument("--K", type=int, required=True, help="输出前K个高频词")
    args = parser.parse_args()

    # 读取所有URL
    with open(args.url_file_path, "r", encoding="utf-8") as f:
        urls = [line.strip() for line in f if line.strip()]

    print(f"共读取到 {len(urls)} 个URL，开始多线程处理...\n")

    # 多线程处理（5个线程）
    with ThreadPoolExecutor(max_workers=5) as executor:
        for url in urls:
            executor.submit(process_one_url, url)

    # 排序，取Top K
    sorted_words = sorted(total_word_freq.items(), key=lambda x: x[1], reverse=True)
    top_k = sorted_words[:args.K]

    # 输出结果
    print(f"\nTop {args.K} frequent words are:")
    for word, count in top_k:
        print(f"{word}: {count}")

if __name__ == "__main__":
    main()