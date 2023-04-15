package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Objects;

public class Country {

   public final String name;
   public final BigDecimal peopleQuantity;

   public Country(String name, BigDecimal peopleQuantity) {
      this.name = name;
      this.peopleQuantity = peopleQuantity;
   }

   public String getName() {
      return name;
   }

   public final BigDecimal getPeopleQuantity() {
      return peopleQuantity;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Country country = (Country) o;

      if (!Objects.equals(name, country.name)) return false;
      return Objects.equals(peopleQuantity, country.peopleQuantity);
   }

}
