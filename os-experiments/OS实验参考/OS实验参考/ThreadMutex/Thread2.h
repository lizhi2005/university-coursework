// Thread2.h : main header file for the THREAD2 application
//

#if !defined(AFX_THREAD2_H__07DA0481_971D_40B9_AC10_0A8D557E9D96__INCLUDED_)
#define AFX_THREAD2_H__07DA0481_971D_40B9_AC10_0A8D557E9D96__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CThread2App:
// See Thread2.cpp for the implementation of this class
//

class CThread2App : public CWinApp
{
public:
	CThread2App();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CThread2App)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation
	//{{AFX_MSG(CThread2App)
	afx_msg void OnAppAbout();
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_THREAD2_H__07DA0481_971D_40B9_AC10_0A8D557E9D96__INCLUDED_)
