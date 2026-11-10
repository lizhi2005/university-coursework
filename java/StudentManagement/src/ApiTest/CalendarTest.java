package ApiTest;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class CalendarTest {
    static void main() {
        //        根据系统不同时区获取不同的日历对象,默认表示当前时间
        //        获取当前时间的Calendar对象
        Calendar c=Calendar.getInstance();
        System.out.println(c);
//月份范围0-11
//        星期范围0-6 0表示星期日
        Date d=new Date(0L);
        c.setTime(d);
        System.out.println(d);
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH)+1);
        System.out.println(c.get(Calendar.DAY_OF_MONTH));


        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        System.out.println(c.get(Calendar.HOUR_OF_DAY));
        System.out.println(c.get(Calendar.MINUTE));
        System.out.println(c.get(Calendar.SECOND));

//        获取所有可用的时区名称
        Set<String> zoneIds= ZoneId.getAvailableZoneIds();
        System.out.println(zoneIds.size());
        System.out.println(zoneIds);
//        获取系统默认时区
      ZoneId zoneId=ZoneId.systemDefault();
        System.out.println(zoneId);


//        获取当前时间的Instant对象
//        Instant now=Instant.now();
//        System.out.println(now);

        Instant instance1=Instant.ofEpochMilli(0L);

        System.out.println(instance1);
        Instant instance2=Instant.ofEpochSecond(1L);
        System.out.println(instance2);
        Instant instance3=Instant.ofEpochSecond(1L,1000000000L);
        System.out.println(instance3);

//        指定时区
        ZonedDateTime time =Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(time);

        Instant instance5=Instant.ofEpochSecond(1L);
        Instant instant = Instant.ofEpochMilli(2000L);
        System.out.println(instant);
        boolean before=instance5.isBefore(instant);
        System.out.println(before);
        boolean after=instance5.isAfter(instant);
        System.out.println(after);

        ZonedDateTime time1=Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EE a");
        System.out.println(formatter.format(time1));













    }






}
