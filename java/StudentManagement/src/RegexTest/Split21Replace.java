package RegexTest;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Split21Replace {
    static void main() throws ParseException {
        String s="沈棠qwertyu123123祁善qwertyu123123";
        String str=s.replaceAll("[\\w&&[^_]]+","kangguo");
//        只有返回值才是改变后的结果
        System.out.println(str);

//        秒杀活动
        String str1="2023年11月11日 0:00:00";
        String str2="2023年11月11日 0:01:00";
        String str3="2023年11月11日 0:11:00";

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date1=sdf.parse(str1);
        Date date2=sdf.parse(str2);
        Date date3=sdf.parse(str3);

        Long l1= date1.getTime();


        Long l3= date2.getTime();
        Long l4= date3.getTime();
        Long l5=1000L*60*10;
        if(l3-l1<=l5&&l3>l1){
            System.out.println("小贾参加了秒杀活动");
        }else{
            System.out.println("小贾没有参加秒杀活动");
        }
        if(l4-l1<=l5&&l4>l5){
            System.out.println("小皮参加了秒杀活动");
        }else{
            System.out.println("小皮没有参加秒杀活动");
        }



    }

    private static void Test2() throws ParseException {
        Date date=new Date();
        System.out.println(date.getTime());

        String time="2023-08-01 12:00:00";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.parse(time));
        System.out.println(sdf.parse(time).getTime());

        String str2="2000-11-11";
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
        Date date2=sdf2.parse(str2);

        System.out.println(date2);
        SimpleDateFormat sdf3=new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(sdf3.format(date2));

        System.out.println(new SimpleDateFormat("yyyy年MM年dd日").format(new Date(String.valueOf((new SimpleDateFormat("yyyy-MM-dd").parse(str2))))));
    }

    private static void timeTest() {
        SimpleDateFormat sdf1=new SimpleDateFormat();
        Date d=new Date(0L);
        String str1=sdf1.format(d);
        System.out.println(str1);


        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str2=sdf2.format(d);
        System.out.println(str2);
    }


}
