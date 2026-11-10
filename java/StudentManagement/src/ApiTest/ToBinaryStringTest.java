package ApiTest;

import java.util.Scanner;

public class ToBinaryStringTest {
    static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个整数");
        String str=sc.nextLine();
        int num=Integer.parseInt(str);
        System.out.println(Integer.toBinaryString(num));
        System.out.println(toBinaryString(num));
    }
  public static String toBinaryString(int num){
        StringBuilder sb=new StringBuilder();
        if(num==0){
            return "0";
        }
        while(true){
            if(num==0){
                break;
            }
            int rem=num%2;
            sb.insert(0,rem);
            num/=2;
        }
        return sb.toString();
  }

}
