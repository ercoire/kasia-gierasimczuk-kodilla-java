package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        Customer customer = new Customer("C001");
        Groceries apple = new Groceries("0234", 2.5, 20, "fruit", LocalDate.of(2023,9,15));
        Order order = new Order("ORD001", LocalDate.of(2023, 5, 19), customer.getCustomerID(), apple, 5);
        Shipment shipment = new Shipment(customer,
                "SH001",
                LocalDate.of(2023, 5, 28),
                ShipmentStatus.PACKING );
        OrderProcessor orderProcessor = new OrderProcessor();


        ProductOrderService orderService = new ProductOrderService(shipment, order, customer, orderProcessor);

        orderService.completeOrder(order, shipment , orderProcessor.createShipmentDto(order, customer, shipment));

/*
        MovieStore movieStore = new MovieStore();


        System.out.println(movieStore.getMovies().values().stream()
                .flatMap(List::stream)
                .collect(Collectors.joining("! ")));

*/

    }

}