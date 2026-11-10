import argparse
import requests
import re
import threading
from queue import Queue
from collections import defaultdict

# --------------------- 全局队列 & 全局变量 ---------------------
url_queue = Queue()       # 线程1 → 线程2
text_queue = Queue()      # 线程2 → 线程3
word_queue = Queue()      # 线程3 → 线程4
global_freq = defaultdict(int)
lock = threading.Lock()

# ===================== 线程1：读取URL文件 =====================
def thread1_read_urls(url_file_path):
    print("[线程1] 开始读取URL列表...")
    with open(url_file_path, "r", encoding="utf-8") as f:
        for line in f:
            url = line.strip()
            if url:
                url_queue.put(url)
    url_queue.put(None)  # 结束标志
    print("[线程1] URL读取完成！")

# ===================== 线程2：下载书籍 =====================
def thread2_download():
    print("[线程2] 开始下载文本...")
    while True:
        url = url_queue.get()
        if url is None:
            text_queue.put(None)
            break
        try:
            headers = {"User-Agent": "Mozilla/5.0"}
            res = requests.get(url, headers=headers, timeout=15)
            res.encoding = "utf-8"
            text_queue.put(res.text)
            print(f"[线程2] 下载成功：{url}")
        except:
            print(f"[线程2] 下载失败：{url}")
    print("[线程2] 所有文本下载完成！")

# ===================== 线程3：清洗 + 归一化 =====================
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
    if w.endswith("ing"): return w[:-3]
    if w.endswith("ed"): return w[:-2]
    if w.endswith("s"): return w[:-1]
    return w

def thread3_clean():
    print("[线程3] 开始清洗文本...")
    while True:
        text = text_queue.get()
        if text is None:
            word_queue.put(None)
            break
        words = re.findall(r"[a-zA-Z]+", text.lower())
        norm_words = [normalize(w) for w in words]
        word_queue.put(norm_words)
    print("[线程3] 文本清洗完成！")

# ===================== 线程4：统计词频 =====================
def thread4_count():
    print("[线程4] 开始统计单词...")
    while True:
        words = word_queue.get()
        if words is None:
            break
        local = defaultdict(int)
        for w in words:
            local[w] += 1
        with lock:
            for k, v in local.items():
                global_freq[k] += v
    print("[线程4] 单词统计完成！")

# ===================== 主线程：输出Top-K =====================
def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("--url_file_path", required=True)
    parser.add_argument("--K", type=int, required=True)
    args = parser.parse_args()

    # 创建5个分工不同的线程
    t1 = threading.Thread(target=thread1_read_urls, args=(args.url_file_path,))
    t2 = threading.Thread(target=thread2_download)
    t3 = threading.Thread(target=thread3_clean)
    t4 = threading.Thread(target=thread4_count)

    t1.start()
    t2.start()
    t3.start()
    t4.start()

    t1.join()
    t2.join()
    t3.join()
    t4.join()

    # 输出Top K
    top_k = sorted(global_freq.items(), key=lambda x: x[1], reverse=True)[:args.K]
    print(f"\nTop {args.K} frequent words are:")
    for w, c in top_k:
        print(f"{w}: {c}")

if __name__ == "__main__":
    main()