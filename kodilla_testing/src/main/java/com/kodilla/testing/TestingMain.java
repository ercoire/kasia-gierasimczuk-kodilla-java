package com.kodilla.testing;

//import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;


public class TestingMain {
   public static void main(String[] args) {

      //Calculator app test
      Calculator calculator = new Calculator();

      int a = 8;
      int b = 3;

      int addingResult = calculator.add(a, b);

      if (addingResult == 11) {
         System.out.println("Adding test OK");
      } else {
         System.out.println("Error in adding test!");
      }

      int subtractingResult = calculator.subtract(a, b);

      if (subtractingResult == 5) {
         System.out.println("Subtracting test OK");
      } else {
         System.out.println("Error in subtracting test!");
      }

   }
}
