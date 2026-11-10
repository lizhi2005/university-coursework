package MapTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapTest6 {
    static void main() {
        ArrayList<String>list1=new ArrayList<>();
        ArrayList<String>list2=new ArrayList<>();
        Collections.addAll(list1,"杨宁,29","杨英,18","林风,13","沈棠,16","赵葳,17","白素,23");
        Collections.addAll(list2,"褚曜,28","共叔武,35","公西仇,19","即墨秋,25","康时,20","顾池,23");
        Stream<String> yang = list1.stream().filter(s -> s.startsWith("杨")).skip(1);
        Stream<String> sanzi = list2.stream().filter(s->s.split(",")[0].length()==3).limit(2);
        List<String> concat = Stream.concat(yang, sanzi).toList();
        ArrayList<Actor>list3=new ArrayList<>();
        for (String s:concat)
        {
            String name=s.split(",")[0];
            int age=Integer.parseInt(s.split(",")[1]);
            list3.add(new Actor(name, age));
        }
        for (Actor a:list3)
        {
            System.out.println(a);
        }





    }









}
