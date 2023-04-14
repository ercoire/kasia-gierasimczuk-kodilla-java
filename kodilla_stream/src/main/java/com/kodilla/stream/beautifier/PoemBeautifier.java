package com.kodilla.stream.beautifier;

public class PoemBeautifier {

   //parametrem metody jest tekst do zmiany i wyrażenie 𝜆 upiększające tekst
   public void beautify(String defaultText, PoemDecorator decorator) {
      String decoratedText = decorator.decorate(defaultText);
      System.out.println("Before: " + defaultText + ", decorated text: " + decoratedText);

   }
}
