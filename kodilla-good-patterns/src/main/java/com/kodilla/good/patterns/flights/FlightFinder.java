package com.kodilla.good.patterns.flights;

import java.util.ArrayList;
import java.util.List;

public class FlightFinder {

    public List<Airport> departures = new ArrayList<>();
    public List<Airport> arrivals = new ArrayList<>();

    Airport gdansk = new Airport("Gdansk", "GDN");


    public boolean searchFlightsFrom(Airport airport) {
        //if arrivals().contains(airport)
        System.out.println("There are available flight from " + airport);
        return false;
    }

    public boolean searchFlightsTo (Airport airport) {
        //if arrivals().contains(airport)
        System.out.println("There are available flight to " + airport);
        return false;
    }

    public boolean searchFlightsWithTransfer(Airport airportA, Airport airportB, Airport airportC){
        if (true /*departures contain A && arrivals contain B*/) {
            if (true /*arrivals contain C && departures contain C*/) {
                System.out.println("We operate between " + airportA + " and " + airportB + " via " + airportC);
                return true;
            }
        }
        return false;
    }
}
