package com.tang.demo1;

public class StringComparator {
    public static void main(String[]args) {
        String A="asdfghjkl";
        String B="sdfghjkla";
        String C=A+A;
        for (int i = 0; i <B.length() ; i++) {
            String S=C.substring(i,i+B.length());
            if(S.equals(B))
            {
                System.out.println("找到了");
                System.out.println(S);
                System.out.println(B);
                break;
            }

        }











































    }


}
