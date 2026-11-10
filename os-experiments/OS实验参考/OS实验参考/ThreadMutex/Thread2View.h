// Thread2View.h : interface of the CThread2View class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_THREAD2VIEW_H__D7840729_EF1D_4E1E_8842_73F1F210937E__INCLUDED_)
#define AFX_THREAD2VIEW_H__D7840729_EF1D_4E1E_8842_73F1F210937E__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "afxmt.h"
class CDataArray
{
private:
	int iArray[10];
	CCriticalSection CriticalSection;
public:
	CDataArray(){};
	~CDataArray(){};

    void SetData(int iValue);
    void GetDataArray(int aArray[10]);
};


class CThread2View : public CScrollView
{
protected: // create from serialization only
	CThread2View();
	DECLARE_DYNCREATE(CThread2View)

// Attributes
public:
	CThread2Doc* GetDocument();

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CThread2View)
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
	virtual ~CThread2View();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CThread2View)
	afx_msg void OnThreadBegin();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

#ifndef _DEBUG  // debug version in Thread2View.cpp
inline CThread2Doc* CThread2View::GetDocument()
   { return (CThread2Doc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_THREAD2VIEW_H__D7840729_EF1D_4E1E_8842_73F1F210937E__INCLUDED_)
