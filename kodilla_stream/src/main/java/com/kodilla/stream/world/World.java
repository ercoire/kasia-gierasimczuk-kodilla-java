package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {

   public final List<Continent> continents = new ArrayList<>();

   public void addContinent(Continent continent) {
      continents.add(continent);
   }

   // używając flatMap() oraz reduce() oblicz sumę ludności wszystkich krajów na wszystkich kontynentach
   public BigDecimal getPeopleQuantity() {
      return continents.stream()
            .flatMap(continent -> continent.getAllCountries().stream())
            .map(Country::getPeopleQuantity)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
   }


}
