import os
from fastapi import FastAPI, File, UploadFile, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from fastapi.responses import StreamingResponse
from pydantic import BaseModel
import shutil
import json  # 新增：用于在流中传输来源数据

# --- LangChain 相关导入 ---
from langchain_community.document_loaders import PyPDFLoader, TextLoader, Docx2txtLoader
from langchain_text_splitters import RecursiveCharacterTextSplitter
from langchain_community.embeddings import DashScopeEmbeddings
from langchain_community.vectorstores import Chroma
from langchain_community.chat_models.tongyi import ChatTongyi
from langchain_core.output_parsers import StrOutputParser
from langchain_core.runnables import RunnablePassthrough
from langchain_core.prompts import ChatPromptTemplate

# ==========================================
# 1. 核心 RAG 逻辑初始化
# ==========================================
os.environ["DASHSCOPE_API_KEY"] = "sk-622b3fb9aa0743e08a4d86efcac0579a"

UPLOAD_DIR = "knowledge_base"
DB_DIR = "chroma_db"
os.makedirs(UPLOAD_DIR, exist_ok=True)

embedding_model = DashScopeEmbeddings(model="text-embedding-v4")

db_client = Chroma(
    collection_name="campus_knowledge",
    persist_directory=DB_DIR,
    embedding_function=embedding_model
)

retriever = db_client.as_retriever(search_kwargs={"k": 6})

chatLLM = ChatTongyi(model="qwen-plus", streaming=True)

template = """你是一个校园知识助手，严格基于提供的上下文回答问题，无相关内容时说"未找到相关信息"。
上下文：{context}
问题：{question}
回答："""
prompt = ChatPromptTemplate.from_template(template)


def format_docs(docs):
    return "\n\n".join(doc.page_content for doc in docs)


print("✅ 系统初始化完成！")

# ==========================================
# 2. FastAPI 服务配置
# ==========================================
app = FastAPI()
app.add_middleware(CORSMiddleware, allow_origins=["*"], allow_methods=["*"], allow_headers=["*"])


class QuestionRequest(BaseModel):
    question: str


# ==========================================
# 3. 接口定义
# ==========================================

@app.post("/upload")
async def upload_file(file: UploadFile = File(...)):
    file_path = os.path.join(UPLOAD_DIR, file.filename)
    try:
        with open(file_path, "wb") as buffer:
            shutil.copyfileobj(file.file, buffer)
        process_rag_pipeline(file_path)
        return {"status": "success", "message": f"文件 '{file.filename}' 上传并向量化成功！"}
    except Exception as e:
        return {"status": "error", "message": str(e)}


def process_rag_pipeline(file_path: str):
    # (保持你原有的处理逻辑不变)
    print(f"--- 开始处理文件: {file_path} ---")
    documents = []
    if file_path.endswith(".pdf"):
        loader = PyPDFLoader(file_path)
    elif file_path.endswith(".txt"):
        loader = TextLoader(file_path, encoding="utf-8")
    elif file_path.endswith(".docx"):
        loader = Docx2txtLoader(file_path)
    else:
        print("不支持的文件格式"); return

    documents = loader.load()
    splitter = RecursiveCharacterTextSplitter(chunk_size=200, chunk_overlap=50,
                                              separators=["\n\n", "\n", "。", "！", "？"])
    text_chunks = splitter.split_documents(documents)
    db_client.add_documents(text_chunks)
    print("--- 处理完成，已入库 ---")


@app.get("/")
async def root():
    return {"message": "RAG后端服务已启动"}