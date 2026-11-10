// Thread2View.cpp : implementation of the CThread2View class
//

#include "stdafx.h"
#include "Thread2.h"

#include "Thread2Doc.h"
#include "Thread2View.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

///////////////////////////////////////////////////////////////////////////////
//CDataArray

void CDataArray::SetData(int iValue)
{
	CriticalSection.Lock();
	for (int i=0;i<10;i++)
		iArray[i]=iValue;
	CriticalSection.Unlock();
}

void CDataArray::GetDataArray(int aArray[10])
{
	CriticalSection.Lock();
	for (int i=0;i<10;i++)
		aArray[i]=iArray[i];
	CriticalSection.Unlock();
}

/////////////////////////////////////////////////////////////////////////////
// CThread2View

CDataArray		DataArray;

IMPLEMENT_DYNCREATE(CThread2View, CScrollView)

BEGIN_MESSAGE_MAP(CThread2View, CScrollView)
	//{{AFX_MSG_MAP(CThread2View)
	ON_COMMAND(ID_THREAD_BEGIN, OnThreadBegin)
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CScrollView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CScrollView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CScrollView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CThread2View construction/destruction

CThread2View::CThread2View()
{
	// TODO: add construction code here

}

CThread2View::~CThread2View()
{
}

BOOL CThread2View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CScrollView::PreCreateWindow(cs);
}

/////////////////////////////////////////////////////////////////////////////
// CThread2View drawing

void CThread2View::OnDraw(CDC* pDC)
{
	CThread2Doc* pDoc = GetDocument();
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
	pDC->SetTextColor(RGB(0,0,255));
	pDC->DrawText("线程同步--使用临界区",Rect,DT_CENTER|DT_VCENTER|DT_SINGLELINE);


	pDC->SelectObject(oldFont);
}

void CThread2View::OnInitialUpdate()
{
	CScrollView::OnInitialUpdate();

	CSize sizeTotal;
	// TODO: calculate the total size of this view
	sizeTotal.cx = sizeTotal.cy = 100;
	SetScrollSizes(MM_TEXT, sizeTotal);
}

/////////////////////////////////////////////////////////////////////////////
// CThread2View printing

BOOL CThread2View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void CThread2View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void CThread2View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

/////////////////////////////////////////////////////////////////////////////
// CThread2View diagnostics

#ifdef _DEBUG
void CThread2View::AssertValid() const
{
	CScrollView::AssertValid();
}

void CThread2View::Dump(CDumpContext& dc) const
{
	CScrollView::Dump(dc);
}

CThread2Doc* CThread2View::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CThread2Doc)));
	return (CThread2Doc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CThread2View message handlers


////////////////////////////////////////////////////////////////////////////
//线程函数

UINT Thread_WriteProc(LPVOID param)
{
	for (int i=0;i<10;i++)
	{
		DataArray.SetData(i);
		::Sleep(500);
	}
	return 0;
}

UINT Thread_ReadProc(LPVOID param)
{
	int aArray[10];
	for (int i=0;i<20;i++)
	{
		DataArray.GetDataArray(aArray);
		char str[255];
		str[0]=0;
		for (int j=0;j<10;j++)
		{
			int len=strlen(str);
			wsprintf(&str[len],"%d",aArray[j]);
		}
		::MessageBox((HWND)param,str,"Thread Read Proc",MB_OK);
	}
	return 0;
}

void CThread2View::OnThreadBegin() 
{
	// TODO: Add your command handler code here
	HWND hWnd=GetSafeHwnd();
	AfxBeginThread(Thread_WriteProc,hWnd);
	AfxBeginThread(Thread_ReadProc,hWnd);
}
