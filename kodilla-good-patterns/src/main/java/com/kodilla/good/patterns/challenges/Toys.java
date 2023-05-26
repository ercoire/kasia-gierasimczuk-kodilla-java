package com.kodilla.good.patterns.challenges;

public class Toys extends Material {

    private String toyType;

    private int age;


    public Toys(String materialID, double price, int stockCount, String toyType, int age) {
        super(materialID, price, stockCount);
        this.toyType = toyType;
        this.age = age;
    }

    public String getToyType() {
        return toyType;
    }


}
