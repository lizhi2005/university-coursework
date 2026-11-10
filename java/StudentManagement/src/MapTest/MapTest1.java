package MapTest;

import java.util.*;

public class MapTest1 {
    static void main() {
        Map<String,String> m=new HashMap<>();
        m.put("宁燕 ","子虚乌有");
        m.put("褚曜 ","柳暗花明");
        m.put("顾池","洞彻窥心");
        m.put("共叔武 ","苍狼啸月");
        m.put("公西仇","沧蛟覆海");
        m.put("祈善","丹青幻妄");
        m.put("沈棠","农事生万物");
        m.put("即墨秋","千机谋算");
        m.put("杨英","破阵枪魂");
        m.put("苏珩","御政权衡");
        m.put("康时","逢赌必输");
        System.out.println(m);
//        m.clear();
//        System.out.println(m);
        boolean result=m.containsKey("沈棠");
        System.out.println(result);
        boolean r1=m.containsValue("逢赌必输");
        System.out.println(r1);
        int size = m.size();
        System.out.println(size);
        boolean empty = m.isEmpty();
        System.out.println(empty);
        Set<String> set=m.keySet();
        for(String st:set){
            String value=m.get(st);
            System.out.println(st+":"+value);
        }
        System.out.println("-----------------");
        Iterator<String> it=set.iterator();
        while(it.hasNext()){
            String st=it.next();
            String value=m.get(st);
            System.out.println(st+":"+value);
        }
        System.out.println("-----------------");
        m.forEach(
                (key,value)->{
                    System.out.println(key+":"+value);
                }
        );
        System.out.println("-----------------");
        Set<Map.Entry<String,String>>entries=m.entrySet();
        for(Map.Entry<String,String>entry:entries){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println("-----------------");

    }



}
