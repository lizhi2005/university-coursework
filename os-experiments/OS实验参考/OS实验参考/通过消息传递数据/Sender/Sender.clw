; CLW file contains information for the MFC ClassWizard

[General Info]
Version=1
LastClass=CSenderDlg
LastTemplate=CDialog
NewFileInclude1=#include "stdafx.h"
NewFileInclude2=#include "Sender.h"

ClassCount=4
Class1=CSenderApp
Class2=CSenderDlg
Class3=CAboutDlg

ResourceCount=3
Resource1=IDD_ABOUTBOX
Resource2=IDR_MAINFRAME
Resource3=IDD_SENDER_DIALOG

[CLS:CSenderApp]
Type=0
HeaderFile=Sender.h
ImplementationFile=Sender.cpp
Filter=N

[CLS:CSenderDlg]
Type=0
HeaderFile=SenderDlg.h
ImplementationFile=SenderDlg.cpp
Filter=D
BaseClass=CDialog
VirtualFilter=dWC

[CLS:CAboutDlg]
Type=0
HeaderFile=SenderDlg.h
ImplementationFile=SenderDlg.cpp
Filter=D

[DLG:IDD_ABOUTBOX]
Type=1
Class=CAboutDlg
ControlCount=4
Control1=IDC_STATIC,static,1342177283
Control2=IDC_STATIC,static,1342308480
Control3=IDC_STATIC,static,1342308352
Control4=IDOK,button,1342373889

[DLG:IDD_SENDER_DIALOG]
Type=1
Class=CSenderDlg
ControlCount=5
Control1=IDOK,button,1342242817
Control2=IDCANCEL,button,1342242816
Control3=IDC_COMMAND1,button,1342242816
Control4=IDC_COMMAND2,button,1342242816
Control5=IDC_COMMAND3,button,1342242816

