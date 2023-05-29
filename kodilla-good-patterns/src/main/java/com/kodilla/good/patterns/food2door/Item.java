package com.kodilla.good.patterns.food2door;

public class Item {

    public String itemName;
    double pricePerUnit;

    public Item(String itemName, int pricePerUnit) {
        this.itemName = itemName;
        this.pricePerUnit = pricePerUnit;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }
}
