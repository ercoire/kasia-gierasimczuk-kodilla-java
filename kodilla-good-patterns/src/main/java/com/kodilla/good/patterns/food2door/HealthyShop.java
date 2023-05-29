package com.kodilla.good.patterns.food2door;

public class HealthyShop extends SupplierProcessor {


    @Override
    public void setShopName() {
        shopName = "HealthyShop";
    }

    @Override
    public String getShopName() {
        return shopName;
    }

    @Override
    public double setDiscountPerUnit() {
        return 0.2;
    }

    @Override
    public void getAvailableProducts() {
    }

    @Override
    public boolean process(Item item) {
        double units = getShopName().length() * 2;
        double extraFoodDiscount = 1;
        double total = item.getPricePerUnit() * units * extraFoodDiscount;
        return total > 0;
    }
}
