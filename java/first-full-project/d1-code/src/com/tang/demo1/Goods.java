package com.tang.demo1;

public class Goods {
    private int id;
    private String name;
    private int price;
    private int stock;

    public Goods(){}
    public Goods(int id, String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }


    public int getStock() {
        return stock;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
       }

    public String getName() {
        return name;
    }
}
