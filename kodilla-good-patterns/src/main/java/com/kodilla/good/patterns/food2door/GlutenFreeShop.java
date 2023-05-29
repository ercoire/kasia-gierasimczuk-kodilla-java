package com.kodilla.good.patterns.food2door;

public class GlutenFreeShop extends SupplierProcessor {


    @Override
    public void setShopName() {
        shopName = "GlutenFreeShop";
    }

    @Override
    public String getShopName() {
        return shopName;
    }


    @Override
    public double setDiscountPerUnit() {
        return 2;
    }

    @Override
    public void getAvailableProducts() {
    }

    @Override
    public boolean process(Item item) {
        double units = 8;
        double extraFoodDiscount = 0.95;
        double total = item.getPricePerUnit() * units * extraFoodDiscount;
        return total > 0;
    }
}
