package com.kodilla.exception.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ChallengeTestSuite {

   @Nested
   @DisplayName("Tests for throwing exception")
   class ThrowingException {

      @Test
      void shouldThrowExceptionForXGreaterThan2() {
         // Given
         SecondChallenge secondChallenge = new SecondChallenge();

         // When-Then
         assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(3, 5));
      }

      @Test
      void shouldThrowExceptionForXEqual2() {
         // Given
         SecondChallenge secondChallenge = new SecondChallenge();

         // When-Then
         assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 5));
      }

      @Test
      void shouldThrowExceptionForXLesserThan1() {
         // Given
         SecondChallenge secondChallenge = new SecondChallenge();

         // When-Then
         assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 5));
      }

      @Test
      @DisplayName("shouldThrowExceptionForXFrom1To2AndYEqual1.5")
      void shouldThrowExceptionForXFrom1To2AndYEqual1_5 (){
         //Given
         SecondChallenge secondChallenge = new SecondChallenge();

         //When-Then
         assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.5, 1.5));
      }
   }

   @Nested
   @DisplayName("Tests for NOT throwing exception")
   class NotThrowingException {

      @Test
      @DisplayName("shouldNotThrowExceptionForXFrom1To2AndYDifferentThan1.5")
      void shouldNotThrowExceptionForXFrom1To2AndYDifferentThan1_5() {
         //Given
         SecondChallenge secondChallenge = new SecondChallenge();

         //When-Then
         assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 7));
      }



      @Test
      @DisplayName("shouldNotThrowExceptionForXEqual1AndYDifferentThan1.5")
      void shouldNotThrowExceptionForXEqual1AndYDifferentThan1_5 (){
         //Given
         SecondChallenge secondChallenge = new SecondChallenge();

         //When-Then
         assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1, 7));
      }
   }
}

