package MapTest;

import java.util.*;
import java.util.stream.Stream;

public class MapTest3 {
    static void main() {
        String[]s=new String[]{"A","B","C","D"};

        Stream.of(s).forEach(System.out::println);
        int[] arr = {1,2,3,4};
        Stream.of(arr).forEach(System.out::println);

        ArrayList<String>list=new ArrayList<>();
        Random r=new Random();
        for (int i = 0; i <80 ; i++) {
            int num=r.nextInt(4);
            list.add(s[num]);
        }
        HashMap<String,Integer>m=new HashMap<>();
        for (String name:list){
            if(m.containsKey(name))
            {
                m.put(name,m.get(name)+1);
            }
            else{
                m.put(name,1);
            }
        }
        Set<Map.Entry<String,Integer>> set=m.entrySet();
        for (Map.Entry<String,Integer> entry:set) {
            System.out.println(entry);
        }
        int max=0;
        for (Map.Entry<String,Integer> entry:set) {
            if(entry.getValue()>max)
            {
                max=entry.getValue();
            }
        }
        System.out.println(max);
        for (Map.Entry<String,Integer> entry:set) {
            if(entry.getValue()==max)
            {
                System.out.println(entry.getKey());
            }
        }










    }
}
