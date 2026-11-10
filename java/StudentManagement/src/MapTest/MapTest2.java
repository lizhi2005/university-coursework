package MapTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest2 {
    static void main() {
        Map<Student,String> m=new HashMap<>();

        m.put(new Student("沈棠",12),"康国");
        m.put(new Student("祈善",18),"晏国");
        m.put(new Student("褚曜",15),"鲁下郡");
        m.put(new Student("即墨秋",17),"前朝遗族");
        m.put(new Student("顾池",16),"未知");
        m.put(new Student("共叔武",19),"龚氏");
        m.put(new Student("公西仇",20),"族地");
        m.put(new Student("康时",18),"康国");
        m.put(new Student("林风",14),"林氏遗族");
        m.put(new Student("姜胜",21),"鲁下郡");


        Set<Map.Entry<Student,String>> set=m.entrySet();
        for (Map.Entry<Student,String> entry:set) {
            System.out.println(entry);
        }














    }






}
