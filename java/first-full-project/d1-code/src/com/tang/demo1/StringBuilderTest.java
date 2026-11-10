package com.tang.demo1;

import java.util.Scanner;

public class StringBuilderTest {
    public static void main(String[] args) {
        //    对称字符串
        Scanner sc=new Scanner(System.in);
        System.out.println("输入一个字符串");
        String s1=sc.nextLine();
        String s2=new StringBuilder().append(s1).reverse().toString();
        System.out.println(s2);
        System.out.println(s1);
        if(s2.equals(s1))
        {
            System.out.println("是回文字符串");
        }
        else{
            System.out.println("不是回文字符串");
        }


        int []arr=new int[]{1,3,4};
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for (int i = 0; i <arr.length ; i++) {
            if(i== arr.length-1)
            {
                sb.append(arr[i]+"]");
            }
            else{
                sb.append(arr[i]+",");
            }
        }
        System.out.println(sb);

    }




}
