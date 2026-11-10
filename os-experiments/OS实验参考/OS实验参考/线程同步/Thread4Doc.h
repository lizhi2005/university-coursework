// Thread4Doc.h : interface of the CThread4Doc class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_THREAD4DOC_H__703C54B7_5251_426D_BDC4_01D5BF1D8E6A__INCLUDED_)
#define AFX_THREAD4DOC_H__703C54B7_5251_426D_BDC4_01D5BF1D8E6A__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CThread4Doc : public CDocument
{
protected: // create from serialization only
	CThread4Doc();
	DECLARE_DYNCREATE(CThread4Doc)

// Attributes
public:

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CThread4Doc)
	public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CThread4Doc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CThread4Doc)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_THREAD4DOC_H__703C54B7_5251_426D_BDC4_01D5BF1D8E6A__INCLUDED_)
