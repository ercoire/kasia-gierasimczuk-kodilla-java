package com.kodilla.good.patterns.challenges;

public class OrderProcessor {



    public ShipmentDto createShipmentDto(Order order, Customer customer, Shipment shipment) {
        if (!(order.getOrderID() == null || customer.getCustomerID() == null)) {
            return new ShipmentDto(shipment.getCustomer(), true);
        } else {
            return null;
        }
    }
}
