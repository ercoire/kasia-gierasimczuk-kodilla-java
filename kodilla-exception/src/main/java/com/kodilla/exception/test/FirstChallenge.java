package com.kodilla.exception.test;

public class FirstChallenge {

   public double divide(double a, double b) throws ArithmeticException {


      if (b == 0) {
         throw new ArithmeticException();
      }
      return a / b;
   }

   /**
    * This main can throw an ArithmeticException!!!
    * @param args
    */
   public static void main(String[] args) {
      FirstChallenge firstChallenge = new FirstChallenge();

      try {
         double result = firstChallenge.divide(3, 0);
         System.out.println("Division result is " + result);
      }
      catch (ArithmeticException e) {
         System.out.println("Try again with b different than 0.");
      }
      finally {
         System.out.println("Just don't mess with dividing by 0.");
      }


   }
}