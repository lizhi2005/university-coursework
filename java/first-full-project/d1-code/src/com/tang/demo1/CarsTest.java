package com.tang.demo1;

import java.util.Scanner;

public class CarsTest {
    static void main() {
        Scanner sc = new Scanner(System.in);
        Cars [] cars = new Cars[3];
        for (int i = 0; i <3 ; i++) {

            System.out.println("请输入品牌：");
            String brand = sc.nextLine();
            System.out.println("请输入价格：");
            int price = sc.nextInt();
            sc.nextLine();
            System.out.println("请输入颜色：");
            String color = sc.nextLine();

            cars[i] = new Cars(brand, price, color);
            
        }
        for (int i = 0; i <3 ; i++) {
            System.out.print("品牌："+cars[i].getBrand()+" ");
            System.out.print("价格："+cars[i].getPrice()+" ");
            System.out.print("颜色："+cars[i].getColor()+"\n");
        }
        sc.close();

    }

}
