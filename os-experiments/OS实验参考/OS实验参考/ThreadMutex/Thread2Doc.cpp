// Thread2Doc.cpp : implementation of the CThread2Doc class
//

#include "stdafx.h"
#include "Thread2.h"

#include "Thread2Doc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CThread2Doc

IMPLEMENT_DYNCREATE(CThread2Doc, CDocument)

BEGIN_MESSAGE_MAP(CThread2Doc, CDocument)
	//{{AFX_MSG_MAP(CThread2Doc)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CThread2Doc construction/destruction

CThread2Doc::CThread2Doc()
{
	// TODO: add one-time construction code here

}

CThread2Doc::~CThread2Doc()
{
}

BOOL CThread2Doc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)
	

	return TRUE;
}



/////////////////////////////////////////////////////////////////////////////
// CThread2Doc serialization

void CThread2Doc::Serialize(CArchive& ar)
{
	if (ar.IsStoring())
	{
		// TODO: add storing code here
	}
	else
	{
		// TODO: add loading code here
	}
}

/////////////////////////////////////////////////////////////////////////////
// CThread2Doc diagnostics

#ifdef _DEBUG
void CThread2Doc::AssertValid() const
{
	CDocument::AssertValid();
}

void CThread2Doc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CThread2Doc commands
