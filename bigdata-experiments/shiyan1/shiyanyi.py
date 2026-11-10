# 完全无 nltk，不下载任何东西，永不报错
import argparse
import requests
import re

# 下载书籍
def download_book(url):
    try:
        headers = {"User-Agent": "Mozilla/5.0"}
        res = requests.get(url, headers=headers, timeout=15)
        res.encoding = "utf-8"
        return res.text
    except:
        print("下载失败")
        return None

# 单词标准化（处理大小写、时态、单复数）
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

# 主程序
def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("--url", required=True)
    parser.add_argument("--count", required=True)
    args = parser.parse_args()

    print("正在下载书籍...")
    text = download_book(args.url)
    if not text: return

    print("正在统计单词...")
    words = re.findall(r"[a-zA-Z]+", text.lower())
    total = len(words)

    target = normalize(args.count)
    count = sum(1 for w in words if normalize(w) == target)

    print(f"\ntotal word count = {total}")
    print(f'"{args.count}" appeared {count} times')

if __name__ == "__main__":
    main()