package com.kodilla.good.patterns.flights;

import java.util.Objects;

public class Flight {

    private final Airport departureAirport;
    private final Airport arrivalAirport;

    public Flight(Airport departureAirport, Airport arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public String toString() {
        return departureAirport.getAirportCode() + "-" + arrivalAirport.getAirportCode()
                + " (" + departureAirport.getAirportName() + " - " + arrivalAirport.getAirportName() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!Objects.equals(departureAirport, flight.departureAirport))
            return false;
        return Objects.equals(arrivalAirport, flight.arrivalAirport);
    }

    @Override
    public int hashCode() {
        int result = departureAirport != null ? departureAirport.hashCode() : 0;
        result = 31 * result + (arrivalAirport != null ? arrivalAirport.hashCode() : 0);
        return result;
    }
}
