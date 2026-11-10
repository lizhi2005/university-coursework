package com.tang.demo1;

import java.util.ArrayList;

public class ArrayListTest {
   public static void main(String[]args) {
       ArrayList <String> list=new ArrayList<>();

       list.add("沈棠");
       list.add("祁善");
       list.add("褚无晦");
       System.out.print("[");
       for (int i = 0; i <list.size() ; i++) {

           if(i== list.size()-1){

               System.out.print(list.get(i));
           }
           else{
               System.out.print(list.get(i)+", ");
           }

       }
       System.out.println("]");
       ArrayList <Integer> list1=new ArrayList<>();
       list1.add(12);
       list1.add(23);
       list1.add(34);
       list1.add(45);
       System.out.print("[");
       for (int i = 0; i <list1.size() ; i++) {

           if(i== list1.size()-1){

               System.out.print(list1.get(i));
           }
           else{
               System.out.print(list1.get(i)+", ");
           }

       }
       System.out.println("]");
       ArrayList <Student> list2=new ArrayList<>();
       Student stu1=new Student(1,"沈棠",13);
       Student stu2=new Student(2,"祁善",18);
       Student stu3=new Student(3,"褚无晦",27);
       list2.add(stu1);
       list2.add(stu2);
       list2.add(stu3);
       System.out.print("[");
       for (int i = 0; i <list2.size() ; i++) {

           if(i== list2.size()-1){
               Student stu=list2.get(i);
               System.out.print("("+stu.getId()+","+stu.getName()+","+stu.getAge()+")");
           }
           else{
               Student stu=list2.get(i);
               System.out.print("("+stu.getId()+","+stu.getName()+","+stu.getAge()+"),");
           }

       }
       System.out.println("]");
       Finduser(list2,1);
    }

public static boolean Finduser(ArrayList<Student>stu,int id){
    for (int i = 0; i < stu.size() ; i++) {
        Student stu1=stu.get(i);
        if(stu1.getId()==id)
        {
            System.out.println("用户存在");
            System.out.print("("+stu1.getId()+","+stu1.getName()+","+stu1.getAge()+")");
            return true;
        }

    }
     return false;

}

}
