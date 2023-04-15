package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
   @Test
   void testGetPeopleQuantity () {
//przetestuje czy metoda getPeopleQuantity() klasy World działa prawidłowo
      //Given
      World world = new World();

      Continent Asia = new Continent("Asia");
      Continent Africa = new Continent("Africa");
      Continent Europe = new Continent("Europe");
      Continent SouthAmerica = new Continent("South America");

      Country Japan = new Country("Japan", new BigDecimal("34500000012"));
      Country Sweden = new Country("Sweden", new BigDecimal("85800858000"));
      Country Portugal = new Country("Portugal", new BigDecimal("222222222"));
      Country Brasil = new Country("Brasil", new BigDecimal("111111111"));
      Country Angola = new Country("Angola", new BigDecimal("13450000000"));

      Asia.addCountry(Japan);
      Europe.addCountry(Sweden);
      Europe.addCountry(Portugal);
      SouthAmerica.addCountry(Brasil);
      Africa.addCountry(Angola);

      world.addContinent(Asia);
      world.addContinent(Africa);
      world.addContinent(Europe);
      world.addContinent(SouthAmerica);


      //When
      BigDecimal allThePeople = world.getPeopleQuantity();

      //Then
      BigDecimal total = new BigDecimal("134084191345");
      assertEquals(total, allThePeople);


   }
}
