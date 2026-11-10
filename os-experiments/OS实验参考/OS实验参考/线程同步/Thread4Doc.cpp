// Thread4Doc.cpp : implementation of the CThread4Doc class
//

#include "stdafx.h"
#include "Thread4.h"

#include "Thread4Doc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CThread4Doc

IMPLEMENT_DYNCREATE(CThread4Doc, CDocument)

BEGIN_MESSAGE_MAP(CThread4Doc, CDocument)
	//{{AFX_MSG_MAP(CThread4Doc)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CThread4Doc construction/destruction

CThread4Doc::CThread4Doc()
{
	// TODO: add one-time construction code here

}

CThread4Doc::~CThread4Doc()
{
}

BOOL CThread4Doc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	return TRUE;
}



/////////////////////////////////////////////////////////////////////////////
// CThread4Doc serialization

void CThread4Doc::Serialize(CArchive& ar)
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
// CThread4Doc diagnostics

#ifdef _DEBUG
void CThread4Doc::AssertValid() const
{
	CDocument::AssertValid();
}

void CThread4Doc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CThread4Doc commands
