package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;


public class StreamMain {

   public static void main(String[] args) {
/*
      7.1 Lambda Expressions
      System.out.println("Welcome to module 7 - Stream");

      In OOP:
      SaySomething saySomething = new SaySomething();
      saySomething.say();

      In OOP, implementing Interface:
      Processor processor = new Processor();                                // [6]
      ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();  // [7]
      processor.execute(executeSaySomething);

      In OOP, using lambda:
      Processor processor = new Processor();
      Executor codeToExecute = ()-> System.out.println("This is an example text.");
      processor.execute(codeToExecute);

      Using Lambda REFERENCE TO METHODS:
      ExpressionExecutor expressionExecutor = new ExpressionExecutor();       // [5]

      System.out.println("Calculating expressions with lambdas");
      expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
      expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
      expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
      expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

      System.out.println("Calculating expressions with method references");
      expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
      expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
      expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
      expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

 */


      PoemBeautifier beautifier = new PoemBeautifier();        //obiekt, na którym lambda się wykona

      beautifier.beautify("firstText", String::toUpperCase);
      beautifier.beautify("secondText", someString -> someString.concat("ABC"));//wykonanie metody
      beautifier.beautify("anotherText", someString -> someString.indent(1));
      beautifier.beautify("yetAnotherText", someString -> someString.replace("a",""));
      beautifier.beautify("a very last text ", someString -> someString.repeat(2));


   }


}

