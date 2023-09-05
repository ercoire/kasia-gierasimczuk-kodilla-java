package com.kodilla.good.patterns.flights;

import java.util.ArrayList;
import java.util.List;

public class FlightFinder {

    private final List<Flight> flights = new ArrayList<>();

    public List<Flight> getFlights() {
        return flights;
    }

    public void searchFlightsFrom(Airport airport) {
        List<Flight> flightsFromAirport = flights.stream()
                .filter(flight -> flight.getDepartureAirport().equals(airport))
                .toList();

        if (flightsFromAirport.isEmpty()) {
            System.out.println("No flights found from " + airport.getAirportName() + "\n");
        } else {
            System.out.println("Flights from " + airport.getAirportName() + ":");
            flightsFromAirport.forEach(flight -> System.out.println(flight.toString()));
            System.out.println();
        }

    }

    public void searchFlightsTo(Airport airport) {
        List<Flight> flightsToAirport = flights.stream()
                .filter(flight -> flight.getArrivalAirport().equals(airport))
                .toList();

        if (flightsToAirport.isEmpty()) {
            System.out.println("No flights found to " + airport.getAirportName() + "\n");
        } else {
            System.out.println("Flights to " + airport.getAirportName() + ":");
            flightsToAirport.forEach(flight -> System.out.println(flight.toString()));
            System.out.println();
        }
    }

    public void searchFlightsWithTransfer(Airport departureAirport, Airport arrivalAirport) {

        List<Flight> flightsWithOneTransfer = flights.stream()
                .filter(flight -> flight.getDepartureAirport().equals(departureAirport))
                .filter(flight -> flights.stream()
                        .anyMatch(f -> f.getDepartureAirport().equals(flight.getArrivalAirport()) &&
                                f.getArrivalAirport().equals(arrivalAirport)))
                .toList();

        if (flightsWithOneTransfer.isEmpty()) {
            System.out.println("No flights with one transfer from " + departureAirport.getAirportName() + " to "
                    + arrivalAirport.getAirportName() + ".");
        } else {
            System.out.println("Flights with one transfer from " + departureAirport.getAirportName() + " to "
                    + arrivalAirport.getAirportName() + ": ");
            flightsWithOneTransfer.forEach(flight -> System.out.println(flight.toString()));
        }

    }
}
