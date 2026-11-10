// Thread4.h : main header file for the THREAD4 application
//

#if !defined(AFX_THREAD4_H__64995532_2DFD_43BF_9959_165D6AB19872__INCLUDED_)
#define AFX_THREAD4_H__64995532_2DFD_43BF_9959_165D6AB19872__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CThread4App:
// See Thread4.cpp for the implementation of this class
//

class CThread4App : public CWinApp
{
public:
	CThread4App();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CThread4App)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation
	//{{AFX_MSG(CThread4App)
	afx_msg void OnAppAbout();
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_THREAD4_H__64995532_2DFD_43BF_9959_165D6AB19872__INCLUDED_)
