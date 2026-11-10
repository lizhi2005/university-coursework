package com.tang.demo1;

import java.util.Random;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println(6+9);
        System.out.println(9*9);
        System.out.println(65/4);
        System.out.println(65%4);
        System.out.println(45-9);
        System.out.println("Hello,World");
        System.out.println("输入一个三位数整数\n");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
//        int i=num/100;
//        int j=(num%100)/10;
//        int k=num%10;
        int i=num%10;
        int j=num/10%10;
        int k=num/100%10;
//        千位 num/1000%10  类似于公式以此类推
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        int []age=new int[]{18,20,22,24,26};
        for(int a1:age){
            if(a1%2==0)
            { a1/=2;
                System.out.println(a1);}
            else { a1*=2;
                System.out.println(a1);}
        }
        String []name=new String[]{"张三","李四","王五","赵六","钱七"};
        double []height=new double[]{1.75,1.8,1.85,1.9,1.95};
        double e=height[0];
        for (double h : height) {
            if (h>e)
            { e=h;}
        }
        System.out.printf("最高身高为：%f",e);


        int sum=0;
        double sum1=0;
        for (int i1 = 0; i1 < age.length; i1++) {
              sum=sum+age[i1];
        }
        for (double h : height) { sum1 += h; }

        System.out.println(sum);
        System.out.println(sum1);
        Random r=new Random();
        int []rnum=new int[10];
        int sum2=0;
        double avg=0.0;
        int count1=0;
        for(int i3=0; i3<rnum.length; i3++){
            rnum[i3] = r.nextInt(100)+1;
            System.out.println(rnum[i3]);
            sum2 += rnum[i3];
        }
        avg=sum2*1.0/rnum.length;
        for(int n:rnum){
            if (n<avg)  {
                System.out.print(n+" ");
                count1++;
            }
        }
        System.out.print('\n');
        System.out.println(sum2);
        System.out.println(avg);
        System.out.println(count1);




        int []ex=new int[]{1,2,3,4,5,6,7,8,9,10};
        for(int i4=0,j4=ex.length-1;i4<j4;i4++,j4--){
            int temp=ex[i4];
            ex[i4]=ex[j4];
            ex[j4]=temp;
        }
        for(int c:ex){
            System.out.print(c+" ");
        }
        System.out.println();
        int []dl=new int[]{1,2,3,4,5,6,7,8,9,10};
        for(int i5=0;i5< dl.length;i5++){
            int k1=r.nextInt(dl.length);
            int temp=dl[i5];
            dl[i5]=dl[k1];
            dl[k1]=temp;
        }
        for(int i5=0;i5< dl.length;i5++){
            System.out.print(dl[i5]+" ");
        }
        System.out.println();
        getsum();
        byte a=45;
        byte b=45;
        System.out.println(equl(a,b));
        System.out.println(equl(1,2));
        int []arrlist=new int[]{1,2,3,4,5,6,7,8,9,10};
        int []arrlist1=copyRange(arrlist,3,7);
        for(int c:arrlist1){
            System.out.print(c+" ");
        }
        System.out.println();


        }

    public static int[] copyRange(int[]arr,int form,int to) {
        int []arrlist=new int[to-form];
        for (int i = form; i <to ; i++) {
            arrlist[i-form]=arr[i];
        }
        return arrlist;
    }

    public static void getsum() {
        int sum=12;
        int sum1=65;
        int sum2=sum1+sum;
        System.out.println(sum2);
    }

    public static boolean equl(byte a,byte b) {
        if (a==b)
        {
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean equl(short a,short b) {
        if (a==b)
        {
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean equl(int a,int b) {
        if (a==b)
        {
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean equl(long a,long b) {
        if (a==b)
        {
            return true;
        }
        else {
            return false;
        }
    }




}


















