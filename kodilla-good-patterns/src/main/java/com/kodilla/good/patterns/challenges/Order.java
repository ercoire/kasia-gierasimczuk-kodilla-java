package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class Order {

    private final String orderID;


    public Order(String orderID, LocalDate createdOn, String customerID, Material material, int pieces) {
        this.orderID = orderID;
    }

    public String getOrderID() {
        return orderID;
    }





}
