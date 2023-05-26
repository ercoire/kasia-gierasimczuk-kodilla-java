package com.kodilla.good.patterns.challenges;

abstract class Material {

    private final String materialID;
    private final double price;
    private final int stock;

    Material(String materialID, double price, int stockCount) {
        this.materialID = materialID;
        this.price = price;
        this.stock = stockCount;
    }
}
