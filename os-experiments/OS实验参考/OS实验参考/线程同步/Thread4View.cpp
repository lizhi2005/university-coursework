// Thread4View.cpp : implementation of the CThread4View class
//

#include "stdafx.h"
#include "Thread4.h"

#include "Thread4Doc.h"
#include "Thread4View.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif  

//////////////////////////////////////////////////////////////////////////////
//CSharedResource

//在构造函数中完成对信号对象的创建：
CSharedResource::CSharedResource()
{
	ptrSemaphore=new CSemaphore(2,2);
}

//在析构函数中完成对信号对象的释放：
CSharedResource::~CSharedResource()
{
	delete ptrSemaphore;
}

void CSharedResource::AccessResource()
{
	CSingleLock SingleLock(ptrSemaphore);
	SingleLock.Lock();
	/* ......
	  资源访问
	*/
	Sleep(1000);
}

/////////////////////////////////////////////////////////////////////////////
// CThread4View

IMPLEMENT_DYNCREATE(CThread4View, CScrollView)

BEGIN_MESSAGE_MAP(CThread4View, CScrollView)
	//{{AFX_MSG_MAP(CThread4View)
	ON_COMMAND(ID_THREAD_BEGIN, OnThreadBegin)
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CScrollView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CScrollView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CScrollView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CThread4View construction/destruction

CThread4View::CThread4View()
{
	// TODO: add construction code here

}

CThread4View::~CThread4View()
{
}

BOOL CThread4View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CScrollView::PreCreateWindow(cs);
}

/////////////////////////////////////////////////////////////////////////////
// CThread4View drawing

void CThread4View::OnDraw(CDC* pDC)
{
	CThread4Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	// TODO: add draw code for native data here
	LOGFONT logFont;
	logFont.lfHeight=24;
	logFont.lfWeight=FW_BOLD;
	logFont.lfOrientation=0;
	logFont.lfEscapement=0;
	logFont.lfStrikeOut=0;
	logFont.lfUnderline=0;
	logFont.lfItalic=0;
	logFont.lfCharSet=GB2312_CHARSET;
	logFont.lfOutPrecision=OUT_DEFAULT_PRECIS;
	logFont.lfClipPrecision=CLIP_DEFAULT_PRECIS;
	logFont.lfQuality=DEFAULT_QUALITY;
	logFont.lfPitchAndFamily=DEFAULT_PITCH|FF_ROMAN;
	strcpy(logFont.lfFaceName,"The Times Roman");

	CFont font;
	font.CreateFontIndirect(&logFont);
	CFont* oldFont=pDC->SelectObject(&font);

	CRect Rect;
	GetClientRect(&Rect);
	pDC->SetTextColor(RGB(255,0,0));
	pDC->DrawText("线程同步--使用信号量",Rect,DT_CENTER|DT_VCENTER|DT_SINGLELINE);


	pDC->SelectObject(oldFont);
}

void CThread4View::OnInitialUpdate()
{
	CScrollView::OnInitialUpdate();

	CSize sizeTotal;
	// TODO: calculate the total size of this view
	sizeTotal.cx = sizeTotal.cy = 100;
	SetScrollSizes(MM_TEXT, sizeTotal);
}

/////////////////////////////////////////////////////////////////////////////
// CThread4View printing

BOOL CThread4View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void CThread4View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void CThread4View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

/////////////////////////////////////////////////////////////////////////////
// CThread4View diagnostics

#ifdef _DEBUG
void CThread4View::AssertValid() const
{
	CScrollView::AssertValid();
}

void CThread4View::Dump(CDumpContext& dc) const
{
	CScrollView::Dump(dc);
}

CThread4Doc* CThread4View::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CThread4Doc)));
	return (CThread4Doc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CThread4View message handlers

CSharedResource SharedResource;

UINT Thread_Proc1(LPVOID param)
{
	SharedResource.AccessResource();
	::MessageBox((HWND)param,"Thread #1 had accessed the Semaphore!","Thread Proc1",MB_OK);
	return 0;
}

UINT Thread_Proc2(LPVOID param)
{
	SharedResource.AccessResource();
	::MessageBox((HWND)param,"Thread #2 had accessed the Semaphore!","Thread Proc2",MB_OK);
	return 0;
}

UINT Thread_Proc3(LPVOID param)
{
	SharedResource.AccessResource();
	::MessageBox((HWND)param,"Thread #3 had accessed the Semaphore!","Thread Proc3",MB_OK);
	return 0;
}

void CThread4View::OnThreadBegin() 
{
	// TODO: Add your command handler code here
	HWND hWnd=GetSafeHwnd();
	AfxBeginThread(Thread_Proc1,hWnd);
	AfxBeginThread(Thread_Proc2,hWnd);
	AfxBeginThread(Thread_Proc3,hWnd);
	
}
