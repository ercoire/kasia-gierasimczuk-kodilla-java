package com.kodilla.good.patterns.challenges;



public class ShipmentDto {

    private final boolean isDelivered;

    public ShipmentDto(Customer customer, boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

}
