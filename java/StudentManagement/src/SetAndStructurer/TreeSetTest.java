package SetAndStructurer;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {



    static void main() {

//        TreeSet<String>ts=new TreeSet<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int i=o1.length()-o2.length();
//                i=i==0?o1.compareTo(o2):i;
//                return i;
//            }
//        });
        TreeSet<String>ts=new TreeSet<>((o1, o2)-> {
                int i=o1.length()-o2.length();
                i=i==0?o1.compareTo(o2):i;
                return i;
        });

        ts.add("aab");
        ts.add("c");
        ts.add("b");
        ts.add("qwer");
        ts.add("gfhj");
//        @Override
//        public static void toString()
//        {
//
//        }
        for(String st1:ts){
            System.out.println(st1);
        }














    }


    public String toString() {
        return "TreeSetTest{}";
    }
}
