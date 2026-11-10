; CLW file contains information for the MFC ClassWizard

[General Info]
Version=1
LastClass=CThread4View
LastTemplate=CDialog
NewFileInclude1=#include "stdafx.h"
NewFileInclude2=#include "Thread4.h"
LastPage=0

ClassCount=5
Class1=CThread4App
Class2=CThread4Doc
Class3=CThread4View
Class4=CMainFrame

ResourceCount=2
Resource1=IDR_MAINFRAME
Resource2=IDD_ABOUTBOX
Class5=CAboutDlg

[CLS:CThread4App]
Type=0
HeaderFile=Thread4.h
ImplementationFile=Thread4.cpp
Filter=N

[CLS:CThread4Doc]
Type=0
HeaderFile=Thread4Doc.h
ImplementationFile=Thread4Doc.cpp
Filter=N

[CLS:CThread4View]
Type=0
HeaderFile=Thread4View.h
ImplementationFile=Thread4View.cpp
Filter=C
BaseClass=CScrollView
VirtualFilter=VWC
LastObject=ID_THREAD_BEGIN


[CLS:CMainFrame]
Type=0
HeaderFile=MainFrm.h
ImplementationFile=MainFrm.cpp
Filter=T




[CLS:CAboutDlg]
Type=0
HeaderFile=Thread4.cpp
ImplementationFile=Thread4.cpp
Filter=D
LastObject=CAboutDlg

[DLG:IDD_ABOUTBOX]
Type=1
Class=CAboutDlg
ControlCount=4
Control1=IDC_STATIC,static,1342177283
Control2=IDC_STATIC,static,1342308480
Control3=IDC_STATIC,static,1342308352
Control4=IDOK,button,1342373889

[MNU:IDR_MAINFRAME]
Type=1
Class=CMainFrame
Command1=ID_APP_EXIT
Command2=ID_VIEW_TOOLBAR
Command3=ID_VIEW_STATUS_BAR
Command4=ID_THREAD_BEGIN
Command5=ID_APP_ABOUT
CommandCount=5

[ACL:IDR_MAINFRAME]
Type=1
Class=CMainFrame
Command1=ID_FILE_NEW
Command2=ID_FILE_OPEN
Command3=ID_FILE_SAVE
Command4=ID_FILE_PRINT
Command5=ID_EDIT_UNDO
Command6=ID_EDIT_CUT
Command7=ID_EDIT_COPY
Command8=ID_EDIT_PASTE
Command9=ID_EDIT_UNDO
Command10=ID_EDIT_CUT
Command11=ID_EDIT_COPY
Command12=ID_EDIT_PASTE
Command13=ID_NEXT_PANE
Command14=ID_PREV_PANE
CommandCount=14

[TB:IDR_MAINFRAME]
Type=1
Class=?
Command1=ID_THREAD_BEGIN
Command2=ID_APP_ABOUT
CommandCount=2

