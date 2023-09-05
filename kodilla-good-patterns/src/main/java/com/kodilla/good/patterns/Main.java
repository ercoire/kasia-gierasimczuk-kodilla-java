package com.kodilla.good.patterns;

import com.kodilla.good.patterns.flights.Airport;
import com.kodilla.good.patterns.flights.Flight;
import com.kodilla.good.patterns.flights.FlightFinder;

public class Main {
    public static void main(String[] args) {

//13.5
        Airport gdansk = new Airport("Gdansk", "GDN");
        Airport krakow = new Airport("Krakow", "KRK");
        Airport poznan = new Airport("Poznan", "POZ");
        Airport warsawChopin = new Airport("Warsaw Chopin", "WAW");
        Airport wroclaw = new Airport("Wroclaw", "WRO");

        Flight KrkGdn = new Flight(krakow, gdansk);
        Flight GdnKrk = new Flight(gdansk, krakow);
        Flight KrkPoz = new Flight(krakow, poznan);
        Flight GdnWro = new Flight(gdansk, wroclaw);
        Flight WroGdn = new Flight(wroclaw, gdansk);
        Flight WawPoz = new Flight(warsawChopin, poznan);
        Flight PozWaw = new Flight(poznan, warsawChopin);

        FlightFinder flightFinder = new FlightFinder();
        flightFinder.getFlights().add(KrkGdn);
        flightFinder.getFlights().add(GdnKrk);
        flightFinder.getFlights().add(KrkPoz);
        flightFinder.getFlights().add(GdnWro);
        flightFinder.getFlights().add(WroGdn);
        flightFinder.getFlights().add(WawPoz);
        flightFinder.getFlights().add(PozWaw);

        flightFinder.searchFlightsFrom(krakow);

        flightFinder.searchFlightsTo(gdansk);

        flightFinder.searchFlightsWithTransfer(krakow, wroclaw);
        flightFinder.searchFlightsWithTransfer(poznan, gdansk);

//13.4
 /*       Customer customer1 = new Customer("C001");
        Groceries apple = new Groceries("0234", 2.5, 20, "fruit", LocalDate.of(2023,9,15));
        Order order = new Order("ORD001", LocalDate.of(2023, 5, 19), customer1.getCustomerID(), apple, 5);
        Shipment shipment = new Shipment(customer,
                "SH001",
                LocalDate.of(2023, 5, 28),
                ShipmentStatus.PACKING );
        OrderProcessor orderProcessor = new OrderProcessor();

        ProductOrderService orderService = new ProductOrderService(shipment, order, customer1, orderProcessor);

        orderService.completeOrder(order, shipment , orderProcessor.createShipmentDto(order, customer1, shipment));
*/
//13.1
/*
        MovieStore movieStore = new MovieStore();


        System.out.println(movieStore.getMovies().values().stream()
                .flatMap(List::stream)
                .collect(Collectors.joining("! ")));

    } */
    }
}