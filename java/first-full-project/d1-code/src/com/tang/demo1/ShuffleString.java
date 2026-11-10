package com.tang.demo1;

import java.util.Random;
import java.util.Scanner;

public class ShuffleString {
    public static void main(String[]args) {
        //    键盘输入任意字符串,打乱顺序
        Scanner sc=new Scanner(System.in);
        System.out.println("输入一个字符串");
        String S=sc.nextLine();
        System.out.println(S);
        System.out.println(suffle(S));
    }

public static String suffle(String S){
    Random r=new Random();
    char[] c=S.toCharArray();
    String S1="";
    int num=r.nextInt(S.length());
    for (int i = 0; i < c.length; i++) {
        char temp=c[num];
        c[num]=c[i];
        c[i]=temp;
    }
    for (int i = 0; i < c.length; i++) {
        S1=S1+c[i];
    }
        return S1;
}

}
