// Thread4View.h : interface of the CThread4View class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_THREAD4VIEW_H__D4E4F1CF_8CFE_4BD4_B1F7_0599591EDEC6__INCLUDED_)
#define AFX_THREAD4VIEW_H__D4E4F1CF_8CFE_4BD4_B1F7_0599591EDEC6__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "afxmt.h"

class CSharedResource
{
private:
	CSemaphore* ptrSemaphore;
public:
	CSharedResource();
	~CSharedResource();
  
	void AccessResource();
};

class CThread4View : public CScrollView
{
protected: // create from serialization only
	CThread4View();
	DECLARE_DYNCREATE(CThread4View)

// Attributes
public:
	CThread4Doc* GetDocument();

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CThread4View)
	public:
	virtual void OnDraw(CDC* pDC);  // overridden to draw this view
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
	protected:
	virtual void OnInitialUpdate(); // called first time after construct
	virtual BOOL OnPreparePrinting(CPrintInfo* pInfo);
	virtual void OnBeginPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnEndPrinting(CDC* pDC, CPrintInfo* pInfo);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CThread4View();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CThread4View)
	afx_msg void OnThreadBegin();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

#ifndef _DEBUG  // debug version in Thread4View.cpp
inline CThread4Doc* CThread4View::GetDocument()
   { return (CThread4Doc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_THREAD4VIEW_H__D4E4F1CF_8CFE_4BD4_B1F7_0599591EDEC6__INCLUDED_)
