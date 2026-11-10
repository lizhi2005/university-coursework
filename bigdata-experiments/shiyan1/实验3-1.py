import argparse
import os
import re
import sys
from collections import defaultdict
from multiprocessing import Process, Queue

# ===================== 实验二原有单词归一化（完全保留） =====================
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

# ===================== 配置 =====================
STOP_WORDS = {"the", "a", "an", "and", "or", "but", "in", "on", "at", "to", "of", "for", "with", "by", "is", "are"}
MIN_WORD_LENGTH = 2

# ===================== 多进程任务 =====================
def file_worker(file_queue: Queue, result_queue: Queue):
    while True:
        file_path = file_queue.get()
        if file_path is None:
            result_queue.put(None)
            break

        file_name = os.path.basename(file_path)
        local_index = defaultdict(int)

        try:
            with open(file_path, "r", encoding="utf-8", errors="ignore") as f:
                text = f.read()
        except:
            continue

        words = re.findall(r"[a-zA-Z]+", text.lower())
        for word in words:
            nw = normalize(word)
            if len(nw) >= MIN_WORD_LENGTH and nw not in STOP_WORDS:
                local_index[nw] += 1

        result_queue.put((file_name, local_index))

def build_global_index(result_queue: Queue, global_index: dict):
    while True:
        item = result_queue.get()
        if item is None:
            break
        fname, word_count = item
        for word, cnt in word_count.items():
            global_index[word][fname] = cnt

# ===================== 搜索 =====================
def search_documents(global_index, keywords, top_k):
    doc_sets = []
    for kw in keywords:
        if kw not in global_index:
            return []
        doc_sets.append(set(global_index[kw].keys()))

    common_docs = set.intersection(*doc_sets) if doc_sets else set()
    if not common_docs:
        return []

    results = []
    for doc in common_docs:
        total = 0
        kw_count = {}
        for kw in keywords:
            c = global_index[kw].get(doc, 0)
            kw_count[kw] = c
            total += c
        results.append((doc, kw_count, total))

    results.sort(key=lambda x: x[2], reverse=True)
    return results[:top_k]

# ===================== 主程序 =====================
def main():
    parser = argparse.ArgumentParser(description="实验三：多进程文档搜索引擎")
    parser.add_argument("--file_dir", required=True, help="文本文件夹路径")
    args = parser.parse_args()

    # 错误1：文件夹不存在
    if not os.path.isdir(args.file_dir):
        print(f"Error: Directory '{args.file_dir}' does not exist.")
        sys.exit(1)

    # 扫描所有txt
    txt_files = [f for f in os.listdir(args.file_dir) if f.endswith(".txt")]
    txt_paths = [os.path.join(args.file_dir, f) for f in txt_files]

    # 错误2：无txt文件
    if not txt_paths:
        print(f"Error: No .txt files found in directory '{args.file_dir}'.")
        sys.exit(1)

    # ===================== 多进程构建索引 =====================
    print("Building index now…")

    file_queue = Queue()
    result_queue = Queue()
    global_index = defaultdict(lambda: defaultdict(int))

    for path in txt_paths:
        file_queue.put(path)
    file_queue.put(None)

    p1 = Process(target=file_worker, args=(file_queue, result_queue))
    p2 = Process(target=build_global_index, args=(result_queue, global_index))

    p1.start()
    p2.start()
    p1.join()
    p2.join()

    print("Index built successfully!")
    print(f"Total documents indexed: {len(txt_files)}")
    print(f"Total unique words: {len(global_index)}")
    print("\nIndex built, ready to search.\n")

    # ===================== 交互式搜索 =====================
    while True:
        search_input = input("Please enter text to search, separated by space: ").strip()

        if search_input.lower() == "exit":
            print("Goodbye!")
            break

        if not search_input:
            print("Error: Search text cannot be empty. Please try again.\n")
            continue

        raw_kws = search_input.split()
        valid_kws = []
        for kw in raw_kws:
            nw = normalize(kw)
            if len(nw) >= MIN_WORD_LENGTH and nw not in STOP_WORDS:
                valid_kws.append(nw)

        if not valid_kws:
            print("Error: No valid search terms (all are stop words or too short).\n")
            continue

        while True:
            k_input = input("Please enter the number of documents you want: ").strip()
            try:
                top_k = int(k_input)
                if top_k <= 0:
                    print("Error: Number of documents must be positive. Using default value 10.")
                    top_k = 10
                break
            except ValueError:
                print("Error: Please enter a valid positive integer.")

        results = search_documents(global_index, valid_kws, top_k)

        print("\nSearch results:")
        if not results:
            print("No documents found containing all search terms.\n")
            continue

        for i, (fname, cnt, total) in enumerate(results, 1):
            print(f"{i}. {fname}")
            parts = [f"{k}({v})" for k, v in cnt.items()]
            print(f"   keyword count: {' | '.join(parts)} | total: {total}\n")

if __name__ == "__main__":
    main()