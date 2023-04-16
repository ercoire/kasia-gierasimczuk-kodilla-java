package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {
   @Test
   void testGetAverage () {
   //przygotować tablicę z przykładowymi wartościami typu int i wywołać metodę getAverage(int[] numbers) interfejsu ArrayOperations.
      //Given
      int[] numbers = new int[8];
      numbers[0] = 34;
      numbers[1] = 1;
      numbers[2] = 33;
      numbers[3] = 66;
      numbers[4] = 11;
      numbers[5] = 9;
      numbers[6] = 65;
      numbers[7] = 7;

      //When
     double expected = ArrayOperations.getAverage(numbers);

      //Then
      assertEquals(28.25, expected);
   }
}
