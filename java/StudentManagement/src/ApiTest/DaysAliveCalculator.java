package ApiTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class DaysAliveCalculator {
    static void main() throws ParseException {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入日期");
        String str=sc.nextLine();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d=sdf.parse(str);
        Date now=new Date();
        System.out.println(d);
        long time=d.getTime();
        long day=time/1000/60/60/24;
        long nowday=now.getTime()/1000/60/60/24;
        System.out.println("您已活"+(nowday-day)+"天");


        LocalDate localDate=LocalDate.of(2005,9,14);
        LocalDate nowDate=LocalDate.now();
        Long days= ChronoUnit.DAYS.between(localDate,nowDate);
        System.out.println(days);


    }
}
