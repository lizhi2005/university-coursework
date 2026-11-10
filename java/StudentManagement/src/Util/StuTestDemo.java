package Util;

import Util.Student1;

import jdk.jshell.execution.Util;

import java.util.ArrayList;

public class StuTestDemo {
    static void main() {
        ArrayList<Student1> list = new ArrayList<>();
        Student1 stu1 = new Student1("张三",25);
        list.add(stu1);
        Student1 stu2 = new Student1("李四",23);
        list.add(stu2);
        Student1 stu3 = new Student1("王五",33);
        list.add(stu3);
        Student1 stu4 = new Student1("赵六",18);
        list.add(stu4);
        Student1 stu5 = new Student1("钱七",25);
        list.add(stu5);
        System.out.println(StuUtil.getAge(list));
    }
}
