package com.company;

public enum Goods {

    BOOK("", 3),
    PHONE("",5);
    private String name;
    private int price;


    Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
