package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class Shipment {

    private final Customer customer;
    private final ShipmentStatus shipmentStatus;

    public Shipment(Customer customer, String shipmentID, LocalDate completionDate, LocalDate pickupDate, ShipmentStatus shipmentStatus1) {
        this.customer = customer;
        this.shipmentStatus = shipmentStatus1;
    }

    public void packOrder (Order order) {
    }

    public void deliverOrder (Order order){
    }

    public Customer getCustomer() {
        return customer;
    }

    public ShipmentStatus getShipmentStatus(){
        return shipmentStatus;
    }

}
