package SetAndStructurer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
    static void main() {
        Set<String>s=new HashSet<>();
        s.add("shentang");
        s.add("qishan");
        s.add("chuwuhui");
        s.add("ninyan");
        s.add("gongxichou");
        s.add("lihua");


        for (String name:s)
        {
            System.out.print(name+" ");
        }

        Iterator<String> iterator = s.iterator();
        while(iterator.hasNext())
        {
            System.out.print(iterator.next()+" ");
        }

        s.forEach(System.out::println);

    }









}
