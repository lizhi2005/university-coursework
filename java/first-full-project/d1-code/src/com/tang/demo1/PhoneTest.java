package com.tang.demo1;

import java.util.ArrayList;

public class PhoneTest {
    static void main() {
        Phone p=new Phone("Apple",5000);
        Phone p1=new Phone("xiaomi",2000);
        Phone p2=new Phone("oppo",2999);
        ArrayList<Phone> list=new ArrayList<>();
        list.add(p);
        list.add(p1);
        list.add(p2);
        ArrayList<Phone> list1=getList(list,3000);
        for (int i = 0; i <list1.size() ; i++) {
            System.out.println(list1.get(i).getBrand()+" "+list1.get(i).getPrice());
        }
    }

    public static ArrayList<Phone> getList(ArrayList<Phone> list,double price) {
        ArrayList<Phone> list1=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).getPrice()<price){
                list1.add(list.get(i));
            }
        }
        return list1;
    }
}
