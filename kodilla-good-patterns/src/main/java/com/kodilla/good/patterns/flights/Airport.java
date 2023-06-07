package com.kodilla.good.patterns.flights;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Airport {

    private final String airportName;
    private final String airportCode;

    public Airport(String airportName, String airportCode) {
        this.airportName = airportName;
        this.airportCode = airportCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        if (!Objects.equals(airportName, airport.airportName)) return false;
        return Objects.equals(airportCode, airport.airportCode);
    }

    @Override
    public int hashCode() {
        int result = airportName != null ? airportName.hashCode() : 0;
        result = 31 * result + (airportCode != null ? airportCode.hashCode() : 0);
        return result;
    }
}
