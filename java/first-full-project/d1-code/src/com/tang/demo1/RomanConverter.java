package com.tang.demo1;

import java.util.Scanner;

public class RomanConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S="";
        StringBuilder sb=new StringBuilder();
        System.out.println("请输入一个字符串");
        System.out.println("长度小于等于9");
        System.out.println("只能是数字");
        while(true){
            S=sc.nextLine();
            boolean flag=Isvaild(S);
            if(flag)
            {
                break;
            }
            else{
                System.out.println("输入不正确请重新输入:");
                continue;
            }
        }

        for (int i = 0; i <S.length() ; i++) {
            char c=S.charAt(i);
            System.out.println(S.charAt(i));
            int number=c-'0';
            sb.append(Roman(number));
        }
        System.out.println(sb);




    }
public static String Roman(int number){
        String []arr=new String[]{" ","I ","II ","III "," IV"," V"," VI","VII "," VIII","IX "};
        return arr[number];
}

    public static boolean Isvaild(String s) {
        if(s.length()>9)
        {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 48 || c >56) {
                return false;
            }
                                            }
return true;
    }

}
