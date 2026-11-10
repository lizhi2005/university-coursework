package com.tang.demo1;

import java.util.Scanner;

public class StringLearning {
    public static void main(String[] args) {
        String phonenumber="12345678910";
        String sub=phonenumber.substring(0,3);
        String sub2=phonenumber.substring(7,11);
        System.out.println(sub+"****"+sub2);
//           索引从0开始
        String id="440304199001010013";
        String sub3=id.substring(6,10);
        System.out.println(sub3);
        String sub4=id.substring(10,12);
        System.out.println(sub4);
        String sub5=id.substring(12,14);
        char sex='男';
        if(Integer.parseInt(id.substring(17,18))%2==0){
            sex='女';
        }
        System.out.printf("人物信息为:%s年%s月%s日",sub3,sub4,sub5);
        System.out.println("性别为:"+sex);













        Scanner sc = new Scanner(System.in);
//        金额转换
        System.out.println("请输入一个金额：(不超过八位数)");
        int money = sc.nextInt();

        String moneyname="";
        moneyname=moneyname+money;
        System.out.println(moneyname);
        int countnum=moneyname.length();
        String Resultmoney="";
        for (int i = 0; i <moneyname.length() ; i++) {
            char c=moneyname.charAt(i);
            if(countnum==1){
                switch(c){
                    case '0':
                        Resultmoney=Resultmoney+"零元";
                        break;
                    case '1':
                        Resultmoney=Resultmoney+"壹元";
                        break;
                    case '2':
                        Resultmoney=Resultmoney+"贰元";
                        break;
                    case '3':
                        Resultmoney=Resultmoney+"叁元";
                        break;
                    case '4':
                        Resultmoney=Resultmoney+"肆元";
                        break;
                    case '5':
                        Resultmoney=Resultmoney+"伍元";
                        break;
                    case '6':
                        Resultmoney=Resultmoney+"陆元";
                        break;
                    case '7':
                        Resultmoney=Resultmoney+"柒元";
                        break;
                    case '8':
                        Resultmoney=Resultmoney+"捌元";
                        break;
                    case '9':
                        Resultmoney=Resultmoney+"玖元";
                        break;
                        default:
                            break;
                }
            }
            if(countnum==2||countnum==6){
                switch(c){
                    case '0':
                        Resultmoney=Resultmoney+"零拾";
                        break;
                    case '1':
                        Resultmoney=Resultmoney+"壹拾";
                        break;
                    case '2':
                        Resultmoney=Resultmoney+"贰拾";
                        break;
                    case '3':
                        Resultmoney=Resultmoney+"叁拾";
                        break;
                    case '4':
                        Resultmoney=Resultmoney+"肆拾";
                        break;
                    case '5':
                        Resultmoney=Resultmoney+"伍拾";
                        break;
                    case '6':
                        Resultmoney=Resultmoney+"陆拾";
                        break;
                    case '7':
                        Resultmoney=Resultmoney+"柒拾";
                        break;
                    case '8':
                        Resultmoney=Resultmoney+"捌拾";
                        break;
                    case '9':
                        Resultmoney=Resultmoney+"玖拾";
                        break;
                    default:
                        break;
                }
            }

            if(countnum==3||countnum==7){
                switch(c){
                    case '0':
                        Resultmoney=Resultmoney+"零佰";
                        break;
                    case '1':
                        Resultmoney=Resultmoney+"壹佰";
                        break;
                    case '2':
                        Resultmoney=Resultmoney+"贰佰";
                        break;
                    case '3':
                        Resultmoney=Resultmoney+"叁佰";
                        break;
                    case '4':
                        Resultmoney=Resultmoney+"肆佰";
                        break;
                    case '5':
                        Resultmoney=Resultmoney+"伍佰";
                        break;
                    case '6':
                        Resultmoney=Resultmoney+"陆佰";
                        break;
                    case '7':
                        Resultmoney=Resultmoney+"柒佰";
                        break;
                    case '8':
                        Resultmoney=Resultmoney+"捌佰";
                        break;
                    case '9':
                        Resultmoney=Resultmoney+"玖佰";
                        break;
                    default:
                        break;
                }
            }
            if(countnum==4||countnum==8){
                switch(c){
                    case '0':
                        Resultmoney=Resultmoney+"零仟";
                        break;
                    case '1':
                        Resultmoney=Resultmoney+"壹仟";
                        break;
                    case '2':
                        Resultmoney=Resultmoney+"贰仟";
                        break;
                    case '3':
                        Resultmoney=Resultmoney+"叁仟";
                        break;
                    case '4':
                        Resultmoney=Resultmoney+"肆仟";
                        break;
                    case '5':
                        Resultmoney=Resultmoney+"伍仟";
                        break;
                    case '6':
                        Resultmoney=Resultmoney+"陆仟";
                        break;
                    case '7':
                        Resultmoney=Resultmoney+"柒仟";
                        break;
                    case '8':
                        Resultmoney=Resultmoney+"捌仟";
                        break;
                    case '9':
                        Resultmoney=Resultmoney+"玖仟";
                        break;
                    default:
                        break;
                }
            }
            if(countnum==5){
                switch(c){
                    case '0':
                        Resultmoney=Resultmoney+"零万";
                        break;
                    case '1':
                        Resultmoney=Resultmoney+"壹万";
                        break;
                    case '2':
                        Resultmoney=Resultmoney+"贰万";
                        break;
                    case '3':
                        Resultmoney=Resultmoney+"叁万";
                        break;
                    case '4':
                        Resultmoney=Resultmoney+"肆万";
                        break;
                    case '5':
                        Resultmoney=Resultmoney+"伍万";
                        break;
                    case '6':
                        Resultmoney=Resultmoney+"陆万";
                        break;
                    case '7':
                        Resultmoney=Resultmoney+"柒万";
                        break;
                    case '8':
                        Resultmoney=Resultmoney+"捌万";
                        break;
                    case '9':
                        Resultmoney=Resultmoney+"玖万";
                        break;
                    default:
                        break;
                }
            }
            countnum--;
        }
        System.out.println(Resultmoney);























                String S = "";
            int[] arr = new int[]{1, 2, 3};
            for (int i = 0; i < arr.length; i++) {
                if (i == 0) {
                    S = S + '[';
                }
                S = S + arr[i];
                if (i == arr.length - 1) {
                    S = S + ']';
                } else {
                    S = S + ',';
                }
            }
            System.out.println(S);


//        字符串反转
            System.out.println("请输入一个字符串：");
            String s3 = sc.nextLine();
            String res = "";
            for (int i = 0; i < s3.length(); i++) {
                int num1 = s3.length() - i - 1;
                System.out.print(s3.charAt(num1) + " ");
                res = res + s3.charAt(num1);
            }
            System.out.println();
            System.out.println(res);


            int countBig = 0;
            int countSmall = 0;
            System.out.println("请输入一个字符串：");
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    countBig++;
                } else if (c >= 'a' && c <= 'z') {
                    countSmall++;
                }
            }
            System.out.println("大写字母的个数为：" + countBig);
            System.out.println("小写字母的个数为：" + countSmall);


//        遍历字符串
            System.out.println("请输入一个字符串：");
            String str = sc.nextLine();
            for (int i = 0; i < str.length(); i++) {
                System.out.println(str.charAt(i));
            }


            String s1 = "admin";
            String s2 = "123456";
            for (int i = 0; i < 3; ) {

                System.out.println("请输入用户名：");
                String username = sc.nextLine();
                System.out.println("请输入密码：");
                String password = sc.nextLine();
                if (username.equals(s1) && password.equals(s2)) {
                    System.out.println("登录成功");
                    break;
                } else {
                    System.out.println("登录失败");
                    i++;
                    if (i <= 2) {
                        System.out.println("还有" + (3 - i) + "次机会");
                    }


                    if (i == 3) {
                        System.out.println("3次登录均失败,账号已被锁定,请联系管理员");
                        break;
                    }

                }
            }


        }
    }

