package com.kodilla.testing.shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("Shape Collector Test Suite")
public class ShapeCollectorTestSuite {


   @Nested
   @DisplayName("Tests for adding figures")
   class TestAddingFigures {

      @Test
      void shouldAddFigure() {
         //Given
         ShapeCollector collector = new ShapeCollector();
         Circle circle = new Circle(5);
         Square square = new Square(6);
         Triangle triangle = new Triangle(10, 7);

         //When
         collector.addFigure(circle);
         collector.addFigure(square);
         collector.addFigure(triangle);

         //Then
         Assertions.assertEquals(circle, collector.getFigure(0));
         Assertions.assertEquals(square, collector.getFigure(1));
         Assertions.assertEquals(triangle, collector.getFigure(2));

      }
   }

   @Nested
   @DisplayName("Tests for removing figures")
   class TestRemovingFigures {
      @Test
      void shouldRemoveFigure() {
         //Given
         ShapeCollector collector = new ShapeCollector();
         Circle circle = new Circle(8);
         Square square = new Square(4);
         Triangle triangle = new Triangle(4, 6);
         collector.addFigure(circle);
         collector.addFigure(square);
         collector.addFigure(triangle);

         //When
         collector.removeFigure(square);

         //Then
         Assertions.assertEquals(circle, collector.getFigure(0));
         Assertions.assertEquals(triangle, collector.getFigure(1));
         Assertions.assertNull(collector.getFigure(2));
      }
   }

   @Nested
   @DisplayName("Tests for getting figures")
   class TestGettingFigures {

      @Test
      void shouldGetFigureFromTheList() {
         //Given
         ShapeCollector collector = new ShapeCollector();
         Circle circle = new Circle(4);
         Square square = new Square(5);
         Triangle triangle = new Triangle(8, 6);

         collector.addFigure(circle);
         collector.addFigure(square);
         collector.addFigure(triangle);

         //When-Then
         Assertions.assertEquals(circle, collector.getFigure(0));
         Assertions.assertEquals(square, collector.getFigure(1));
         Assertions.assertEquals(triangle, collector.getFigure(2));

      }

      @Test
      void shouldNotGetFigureFromOutsideTheList() {
         //Given
         ShapeCollector collector = new ShapeCollector();

         //When-Then
         Assertions.assertNull(collector.getFigure(1));
      }
   }

   @Nested
   @DisplayName("Tests for showing figures")
   class TestShowFigures {

      @Test
      void shouldGiveAllFiguresNamesAsAString() {
         //Given
         ShapeCollector collector = new ShapeCollector();
         Circle circle = new Circle(2);
         Square square = new Square(2);
         Triangle triangle = new Triangle(2, 3);

         collector.addFigure(circle);
         collector.addFigure(square);
         collector.addFigure(triangle);

         //When
         String result = collector.showFigures();

         //Then
         String expected = "circlesquaretriangle";
         Assertions.assertEquals(expected, result);
      }
   }
}


