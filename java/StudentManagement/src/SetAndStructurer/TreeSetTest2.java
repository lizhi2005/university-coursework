package SetAndStructurer;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest2 {
    static void main() {
//        TreeSet<Student> ts=new TreeSet<>(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                int i=o1.getChinese()-o2.getChinese();
//                i=i==0?o1.getMath()-o2.getMath():i;
//                i=i==0?o1.getEnglish()-o2.getEnglish():i;
//                i=i==0?o1.getAge()-o2.getAge():i;
//                i=i==0?o1.getName().compareTo(o2.getName()):i;
//                return i;
//            }
//        });
        TreeSet<Student> ts=new TreeSet<>((Student o1, Student o2) ->{
//            比较总分，总分相同的比较数学成绩
                int sum1=o1.getChinese()+o1.getMath()+o1.getEnglish();
                int sum2=o2.getChinese()+o2.getMath()+o2.getEnglish();
                int i=sum2-sum1;
//            总分相同的比较数学成绩
                i=i==0?o2.getMath()-o1.getMath():i;
//            数学成绩相同的比较英语成绩
                i=i==0?o2.getEnglish()-o1.getEnglish():i;
//            英语成绩相同的比较年龄
                i=i==0?o2.getAge()-o1.getAge():i;
//            年龄相同的比较姓名
                i=i==0?o2.getName().compareTo(o1.getName()):i;
                return i;
            }
        );

        ts.add(new Student("张三", 18, 90, 80, 70));
        ts.add(new Student("李四", 19, 85, 90, 85));
        ts.add(new Student("王五", 20, 95, 85, 90));

        for(Student st1:ts){
            System.out.println(st1);
        }













    }
}
