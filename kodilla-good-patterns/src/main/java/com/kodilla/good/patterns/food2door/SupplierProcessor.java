package com.kodilla.good.patterns.food2door;

abstract class SupplierProcessor {

    protected String shopName;

    public abstract double setDiscountPerUnit();

    public abstract String getShopName();

    public abstract void setShopName();

    public abstract void getAvailableProducts();

    public void displayCompletedOrder(){
        System.out.println("Order has been completed.");
    }

    public boolean process(Item item){
        return false;
    }
}
