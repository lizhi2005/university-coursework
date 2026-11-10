package com.tang.demo1;

public class GoodsTest {
    public static void main(String[] args) {
        Goods g1 = new Goods(1, "小米", 100, 100);
        Goods g2 = new Goods(2, "大米", 200, 200);
        Goods g3 = new Goods(3, "苹果", 300, 300);

        Goods[] goods = {g1, g2, g3};
        for (int i = 0; i < goods.length; i++) {
            System.out.print(goods[i].getId()+" ");
            System.out.print(goods[i].getName()+" ");
            System.out.print(goods[i].getPrice()+" ");
            System.out.print(goods[i].getStock()+" ");
            System.out.println();
        }

    }



}
