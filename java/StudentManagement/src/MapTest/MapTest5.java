package MapTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapTest5 {

    static void main() {
        ArrayList<String>list=new ArrayList<>();
        Collections.addAll(list,"zhangsan,23","lisi,24","wangwu,25");
        Map<String,Integer>m=list.stream().filter(s->Integer.parseInt(s.split(",")[1])>= 24)
                .collect(Collectors.toMap(
                        s -> s.split(",")[0],
                        s->Integer.parseInt(s.split(",")[1])));


//        Map<String, Integer> map = list.stream()
//                .filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
//                .collect(Collectors.toMap(
//                        s -> s.split(",")[0],
//                        s -> Integer.parseInt(s.split(",")[1])
//                ));

        Set<Map.Entry<String, Integer>> set=m.entrySet();
        for(Map.Entry<String, Integer> s:set)
        {
            System.out.println(s.getKey()+":"+s.getValue());
        }






    }












}
