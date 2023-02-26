package com.kodilla.testing.collection;
import java.util.*;


public class OddNumbersExterminator {

   public List<Integer> exterminate(List<Integer> numbers) {
      List<Integer> onlyOddNumbers = new ArrayList<>();

      for (int num : numbers) {
         if (num %2 == 0) {
            onlyOddNumbers.add(num);
         }
      }
      return onlyOddNumbers;
   }



}
