package SetAndStructurer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CollectionClass {

    static void main() {
        List<String> list=new ArrayList<>();
        list.add("shentang");
        list.add("qishan");
        list.add("gongxichou");
        list.add("ningyan");

        list.add(3,"chuwuhui");
        list.add(2,"zhangsan");
        System.out.println(list);
//        String removed = list.remove(2);
//        boolean zhangsan = list.remove("zhangsan");
//        System.out.println(removed);
//        System.out.println(zhangsan);
        for (String s : list) {
            System.out.print(s+" ");
        }
        System.out.println();

        Iterator<String> it= list.iterator();
        while(it.hasNext()) {
            System.out.print(it.next()+" ");
        }
        System.out.println();

        list.forEach(s->System.out.print(s+" "));
        System.out.println();

        list.forEach(System.out::println);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        ListIterator<String> it2= list.listIterator();
        while(it2.hasNext()) {
            System.out.print(it2.next()+" ");
        }
        System.out.println();

    }















}
