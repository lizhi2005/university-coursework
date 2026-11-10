package RegexTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestDemo {
    static void main() {
        String str="1991年的Green Project，当时的目标是为消费电子产品开发语言。然后提到1995年Java的正式发布，以及Java1.0的推出。" +
                "接着，需要按时间顺序列出主要版本，比如Java ]2（1998），Java5（2004）引入的泛型、" +
                "枚举等特性，Java8（2014）的lambda表达式和流API，然后是Java9到Java21的更新，包括模块化系统、虚拟线程等。";
        Pattern p=Pattern.compile("Java\\d{0,2}");
        Matcher m=p.matcher(str);
        while(m.find()){
            String s=m.group();
            System.out.println(s);
        }

    }


}
