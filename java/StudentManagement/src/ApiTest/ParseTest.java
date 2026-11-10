package ApiTest;

import java.util.Scanner;

public class ParseTest {
    static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个整数");
        String str=sc.nextLine();
        String regex="[1-9]\\d{0,9}";
        boolean b=str.matches(regex);
        if(b){
            int num=parseInt(str);
            System.out.println(num+1);
        }
    }
    public static int parseInt(String str){
        int sum=0;
        for (int i = 0; i <str.length() ; i++) {
            char c=str.charAt(i);
            int num=c-'0';
           sum=sum*10+num;
        }
        return sum;
    }


}
