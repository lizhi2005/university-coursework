package com.tang.demo1;

import java.util.Random;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入一个小数");
        double d=sc.nextDouble();

        System.out.println("你输入的小数是："+d);
        Random r=new Random();
        double f=r.nextDouble();
        System.out.println("随机数是："+f);
    }
}
