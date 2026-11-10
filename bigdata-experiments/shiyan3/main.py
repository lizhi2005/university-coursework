import argparse
import os
import re
from collections import defaultdict

# 全局倒排索引：key=单词，value= {文件名: 出现次数}
inverted_index = defaultdict(dict)

def build_index(file_dir):
    """单进程构建索引（只调用一次）"""
    print("\n========== 开始构建索引 ==========\n")
    txt_files = []
    # 遍历所有txt
    for root, _, files in os.walk(file_dir):
        for file in files:
            if file.endswith(".txt"):
                txt_files.append(os.path.join(root, file))

    print("找到的txt文件：")
    for p in txt_files:
        print("  ", p)
    print()

    # 清空旧索引，防止叠加
    inverted_index.clear()

    for file_path in txt_files:
        filename = os.path.basename(file_path)
        print(f"正在处理：{filename}")
        try:
            with open(file_path, 'r', encoding='utf-8', errors='ignore') as f:
                text = f.read().lower()
                # 只保留a-z单词
                words = re.findall(r'[a-z]+', text)
                for word in words:
                    if len(word) > 1:
                        # 统计词频
                        inverted_index[word][filename] = inverted_index[word].get(filename, 0) + 1
        except Exception as e:
            print(f"读取失败 {file_path}: {e}")

    print("\n========== 索引构建完成 ==========\n")
    print(f"文档数：{len(txt_files)}")
    print(f"不同单词数：{len(inverted_index)}")
    print("前10个词示例：", list(inverted_index.keys())[:10])
    print()

def search_documents(keywords, top_n):
    """从索引检索"""
    doc_match = defaultdict(lambda: defaultdict(int))
    for word in keywords:
        word = word.lower()
        if word not in inverted_index:
            print(f"（提示：关键词 '{word}' 不在索引中）")
            continue
        # 把该词对应的所有文档+次数合并
        for doc, cnt in inverted_index[word].items():
            doc_match[doc][word] = cnt

    # 按总词频降序
    sorted_docs = sorted(
        doc_match.items(),
        key=lambda x: sum(x[1].values()),
        reverse=True
    )
    return sorted_docs[:top_n]

def main():
    parser = argparse.ArgumentParser(description="Simple document search engine")
    parser.add_argument(
        "--file_dir",
        default=r"D:\pycharm-project\PythonProject1\PythonProject1",
        help="Path to txt files directory"
    )
    args = parser.parse_args()

    # 只建一次索引！
    build_index(args.file_dir)
    print("索引就绪，可开始搜索（输入 exit 退出）\n")

    while True:
        query = input("请输入关键词（空格分隔）：").strip()
        if query.lower() == "exit":
            print("Goodbye!")
            break
        if not query:
            print("请输入有效关键词\n")
            continue

        keywords = query.split()

        # 让用户输入top_n，加容错
        try:
            top_n = int(input("返回前N个文档："))
        except ValueError:
            print("输入不是数字，默认返回前5个")
            top_n = 5

        results = search_documents(keywords, top_n)

        print("\n----- 搜索结果 -----")
        if not results:
            print("无匹配文档")
        else:
            for i, (doc, word_cnt) in enumerate(results, 1):
                total = sum(word_cnt.values())
                count_str = " | ".join([f"{k}({v})" for k, v in word_cnt.items()])
                print(f"{i}. {doc}")
                print(f"   词频：{count_str} | 总计：{total}\n")

if __name__ == "__main__":
    main()