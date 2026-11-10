// SenderDlg.h : header file
//

#if !defined(AFX_SENDERDLG_H__F071E7C7_6DA0_11D6_8F32_00E04CE76240__INCLUDED_)
#define AFX_SENDERDLG_H__F071E7C7_6DA0_11D6_8F32_00E04CE76240__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

/////////////////////////////////////////////////////////////////////////////
// CSenderDlg dialog

class CSenderDlg : public CDialog
{
// Construction
public:
	CSenderDlg(CWnd* pParent = NULL);	// standard constructor

// Dialog Data
	//{{AFX_DATA(CSenderDlg)
	enum { IDD = IDD_SENDER_DIALOG };
		// NOTE: the ClassWizard will add data members here
	//}}AFX_DATA

	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CSenderDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	HICON m_hIcon;

	// Generated message map functions
	//{{AFX_MSG(CSenderDlg)
	virtual BOOL OnInitDialog();
	afx_msg void OnSysCommand(UINT nID, LPARAM lParam);
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	afx_msg void OnCommand1();
	afx_msg void OnCommand2();
	afx_msg void OnCommand3();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_SENDERDLG_H__F071E7C7_6DA0_11D6_8F32_00E04CE76240__INCLUDED_)
