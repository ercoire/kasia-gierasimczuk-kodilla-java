package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop extends SupplierProcessor {



    @Override
    public String getShopName() {
        return shopName;
    }

    @Override
    public void setShopName() {
        shopName = "ExtraFoodShop";
    }


    @Override
    public double setDiscountPerUnit() {
        return 1.5;
    }


    @Override
    public void getAvailableProducts() {
    }


    @Override
    public boolean process(Item item) {
        double units = shopName.length();
        double extraFoodDiscount = 0.87;
        double total = item.getPricePerUnit() * units * extraFoodDiscount;
        return total > 0;
    }

}
