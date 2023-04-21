package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

   public void findFlight (Flight flight) throws RouteNotFoundException {
      Map<String, Boolean> availableAirport = new HashMap<>();
      availableAirport.put("WAW", true);
      availableAirport.put("KRK", false);
      availableAirport.put("VIE", true);
      availableAirport.put("ARN", false);

      if (availableAirport.containsKey(flight.getDepartureAirport()) && availableAirport.containsKey(flight.getArrivalAirport())) {
         if (!availableAirport.get(flight.getDepartureAirport()) || !availableAirport.get(flight.getArrivalAirport())) {
            System.out.println("Airport(s) not available");
         } else {
            System.out.println("Flight from " + flight.getDepartureAirport() + " to " + flight.getArrivalAirport() + " is available.");
         }
      } else {
         throw new RouteNotFoundException();
      }
   }

      /* Stwórz klasę zawierającą logikę imitującą wyszukiwanie lotów:
logika powinna wyszukiwać loty w mapie. Jeżeli dane lotnisko nie będzie istnieć w mapie, należy
rzucić wyjątkiem RouteNotFoundException.
 */

   public static void main(String[] args) {
      FlightFinder finder = new FlightFinder();
      Flight wawToVie = new Flight("WAW", "VIE");
      Flight krkToBer = new Flight("KRK", "BER");
      Flight krkToArn = new Flight("KRK", "ARN");

      try {
         finder.findFlight(wawToVie);
      } catch (RouteNotFoundException e) {
         System.out.println("Airport not found!");
      }

      try {
         finder.findFlight(krkToBer);
      } catch (RouteNotFoundException e) {
         System.out.println("Airport not found!");
      }

      try {
         finder.findFlight(krkToArn);
      } catch (RouteNotFoundException e) {
         System.out.println("Airport not found!");
      }

   }

}
