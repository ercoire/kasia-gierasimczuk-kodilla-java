package com.kodilla.good.patterns.challenges;

public class ProductOrderService {


    final Shipment shipment;
    final Order order;
    final Customer customer;
    final OrderProcessor orderProcessor;

    public ProductOrderService(Shipment shipment, Order order, Customer customer, OrderProcessor orderProcessor) {
        this.shipment = shipment;
        this.order = order;
        this.customer = customer;
        this.orderProcessor = orderProcessor;
    }

    public ShipmentStatus completeOrder(Order order, Shipment shipment, ShipmentDto shipmentDto) {
        if (!shipmentDto.isDelivered()) {
            if (!(shipment.getShipmentStatus().equals(ShipmentStatus.FAILED))) {
                shipment.packOrder(order);
                shipment.deliverOrder(order);
            }
        }
        return ShipmentStatus.COMPLETED;
    }


}
