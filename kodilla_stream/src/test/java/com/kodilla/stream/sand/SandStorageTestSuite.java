package com.kodilla.stream.sand;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SandStorageTestSuite {

   @Test
   void testGetSandBeansQuantity() {
      //Given
      List<SandStorage> continents = new ArrayList<>();
      continents.add(new Europe());
      continents.add(new Asia());
      continents.add(new Africa());

      //When
      BigDecimal totalSand = BigDecimal.ZERO;
//      BigDecimal totalSand = new BigDecimal("0");
      for (SandStorage continent : continents) {
         totalSand = totalSand.add(continent.getSandBeansQuantity());
      }

      //Then
      BigDecimal expectedSand = new BigDecimal("211111110903703703670");
      assertEquals(expectedSand, totalSand);
   }

   @Test
   void testGetSandBeansQuantityWithReduce() {
      //Given
      List<SandStorage> continents = new ArrayList<>();
      continents.add(new Europe());
      continents.add(new Asia());
      continents.add(new Africa());

      //When
      BigDecimal totalSand = continents.stream()                              // [1]
            .map(SandStorage::getSandBeansQuantity)                              // [2]
            .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));  // [3]

      //Then
      BigDecimal expectedSand = new BigDecimal("211111110903703703670");      // [4]
      assertEquals(expectedSand, totalSand);                                  // [5]
   }
}
