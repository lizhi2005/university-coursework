package ApiTest;

import java.util.Calendar;
import java.util.Scanner;

public class LeapYearValidator {
    static void main() {
        System.out.println("请输入年份");
        Scanner sc=new Scanner(System.in);
        String year=sc.nextLine();
        int yearInt=Integer.parseInt(year);
        System.out.println(year);
        System.out.println( LeapYear(yearInt));

    }
    public static boolean LeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}


