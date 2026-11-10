package QuotionMethod;

import java.util.ArrayList;
import java.util.Collections;

public class Test2 {
    static void main() {
        ArrayList<Student> list=new ArrayList<>();
        Collections.addAll(list,new Student("zhangsan",23),
                new Student("lisi",24),
                new Student("wangwu",25),
                new Student("zhaoliu",26) );
        String[] arr = list.stream()
                .map(Student::getName)
                .toArray(String[]::new);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
    
    
    
    
    
    
}
