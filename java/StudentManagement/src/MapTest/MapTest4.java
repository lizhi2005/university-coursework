package MapTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class MapTest4 {
    static void main() {
        ArrayList<Integer>list=new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        list.add(8);
//        list.add(9);
//        过滤奇数只保留偶数
        boolean b = Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream().filter(value -> value % 2 == 0).toList();
        System.out.println(b);















    }





}
