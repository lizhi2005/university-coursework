package com.tang.demo1;

import java.util.Random;

public class IdentySuffle {
    public static void main(String []args) {
        String S=CreateIdentity();
        System.out.println(S);
        String S1=suffle(S);
        System.out.println(S1);
    }
    public static String CreateIdentity(){
        char[]arr=new char[52];
        for (int i = 0; i <arr.length ; i++) {
            if(i<26){
                arr[i]=(char)('A' + i) ;
            }
            else {
                arr[i]=(char)('a'+i-26);
            }
        }
        Random r=new Random();
        String S1="";
        for (int i = 0; i <4 ; i++) {
            S1=S1+arr[r.nextInt(arr.length)];
        }
        S1=S1+r.nextInt(10);
        return S1;
    }


    public static String suffle(String S){
        Random r=new Random();
        char[] c=S.toCharArray();
        for (int i = c.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1); // 随机位置范围 [0, i]
            // 交换 c[i] 和 c[j]
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
        return new String(c);
    }
}
