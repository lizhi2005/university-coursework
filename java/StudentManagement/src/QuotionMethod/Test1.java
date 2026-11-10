package QuotionMethod;

import java.util.ArrayList;
import java.util.Collections;

public class Test1 {
    static void main() {
        ArrayList<String>list=new ArrayList<>();
        Collections.addAll(list,"zhangsan,23","lisi,24","wangwu,25","zhaoliu,26");

        Student[] stu=list.stream()
                .map(Student::new)
                .toArray(Student[]::new);
        for (int i = 0; i < stu.length; i++) {
            System.out.println(stu[i]);
        }










    }








}
