# # 导入命令行参数解析库，用于获取--url和--count参数
# import argparse
# # 导入网络请求库，用于从URL下载书籍文本
# import requests
# # 导入正则表达式库，用于提取单词
# import re
# # 导入词形还原库，用于统一单词形式（如took→take, taken→take）
# from nltk.stem import WordNetLemmatizer
# # 导入词性标注工具
# from nltk import pos_tag
# # 下载必要的NLTK数据（第一次运行会自动下载）
# import nltk
# nltk.download('wordnet')
# nltk.download('averaged_perceptron_tagger')
# nltk.download('omw-1.4')
#
# # 1. 配置命令行参数
# # 创建参数解析器，用于接收--url和--count输入
# parser = argparse.ArgumentParser(description="书籍单词统计工具")
# parser.add_argument('--url', required=True, type=str, help="书籍文本URL地址")
# parser.add_argument('--count', required=True, type=str, help="需要统计的单词")
# args = parser.parse_args()
#
# # 2. 从URL下载文本内容
# print("正在下载文本...")
# response = requests.get(args.url)
# # 设置编码，解决乱码问题
# response.encoding = 'utf-8'
# text = response.text
#
# # 3. 提取所有单词（只保留字母，过滤标点、数字）
# words = re.findall(r'[a-zA-Z]+', text)
# # 统计总单词数
# total_words = len(words)
#
# # 4. 单词标准化：小写 + 词形还原（统一变形单词）
# lemmatizer = WordNetLemmatizer()
# normalized_words = []
# target_word = args.count.lower()
#
# for word in words:
#     # 转小写，统一大小写
#     lower_word = word.lower()
#     # 词形还原，把过去式、复数、分词还原为原型
#     lemma_word = lemmatizer.lemmatize(lower_word)
#     normalized_words.append(lemma_word)
#
# # 5. 统计目标单词出现次数
# target_count = normalized_words.count(target_word)
#
# # 6. 输出结果
# print(f"total word count = {total_words}")
# print(f'"{args.count}" appeared {target_count} times')
