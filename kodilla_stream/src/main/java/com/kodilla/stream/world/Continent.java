package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {

   private final String name;
   private final List<Country> allCountries = new ArrayList<>();

   public Continent(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public List<Country> getAllCountries() {
      return allCountries;
   }

   public void addCountry(Country country) {
      allCountries.add(country);
   }

}
