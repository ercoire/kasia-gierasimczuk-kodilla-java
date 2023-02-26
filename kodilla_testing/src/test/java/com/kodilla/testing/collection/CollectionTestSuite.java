package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.*;


@DisplayName("CollectionTestSuite")
public class CollectionTestSuite {


   @BeforeEach
   public void before() {
      System.out.println("Test Case: begin");
   }

   @AfterEach
   public void after() {
      System.out.println("Test Case: end");
   }

   @BeforeAll
   public static void beforeAll() {
      System.out.println("Collection Test Suite: begin");
   }

   @AfterAll
   public static void afterAll() {
      System.out.println("Collection Test Suite: end");
   }

   @DisplayName("when the list is empty," + "then class should not filter out any values")

   @Test
   void testOddNumbersExterminatorEmptyList() {
      //Given
      List<Integer> numbers = new ArrayList<>();
      OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

      //When
      List<Integer> testResult = oddNumbersExterminator.exterminate(numbers);

      //Then
      Assertions.assertEquals(0, testResult.size());
   }

   @DisplayName("when the list contains even and odd numbers," + "then class should filter out odd numbers")
   //testOddNumbersExterminatorNormalList – sprawdzający, czy klasa zachowuje się poprawnie, gdy lista zawiera liczby parzyste i nieparzyste.
   @Test
   void testOddNumbersExterminatorNormalList() {
      //Given
      List<Integer> numbers = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
         numbers.add(i);
      }
      OddNumbersExterminator oddNumbersExterminator2 = new OddNumbersExterminator();

      //When
      List<Integer> testResult2 = oddNumbersExterminator2.exterminate(numbers);

      //Then
      List <Integer> testList = new ArrayList<>();
      testList.add(0);
      testList.add(2);
      testList.add(4);
      Assertions.assertEquals(testList, testResult2);
   }
}

