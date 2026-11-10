package Util;

import Util.Student1;

import java.util.ArrayList;

public class StuUtil {
    private StuUtil(){}

    public static int getAge(ArrayList<Util.Student1> list) {
        int max = list.get(0).getAge();
        for (int i = 0; i < list.size(); i++) {
            int age=list.get(i).getAge();
            if(age>max){
                max=age;
            }
        }
        return max;
    }
}
