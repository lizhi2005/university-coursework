package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Test1 {
    static void main() {

        Friend f1=new Friend("shentang",16,184);
        Friend f2=new Friend("gongxichou",19,196);
        Friend f3=new Friend("qishan",22,188);
        Friend f4=new Friend("chuwuhui",29,182);
        Friend[] friendArray = {f1,f2,f3,f4};


        Arrays.sort(friendArray ,new Comparator<Friend>() {
            @Override
            public int compare(Friend o1, Friend o2) {
                int age = o1.getAge() - o2.getAge();
                if (age != 0) {
                    return age;
                }
                int heightCompare = Double.compare(o1.getHeight(), o2.getHeight());
                if (heightCompare != 0) {
                    return heightCompare;
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        for(Friend friend:friendArray){
            System.out.println(friend);
        }


    }


}
