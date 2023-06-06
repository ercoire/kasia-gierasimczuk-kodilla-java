package com.kodilla.patterns.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeFactoryTestSuite {
    @Test
    void testFactoryCircle() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape circle = factory.makeShape(ShapeFactory.CIRCLE);
        //Then
        assertEquals(Math.PI * Math.pow(4.50, 2.0), circle.getArea(), 0);
        assertEquals("The rounded circle", circle.getName());
    }

    @Test
    void testFactorySquare() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape square = factory.makeShape(ShapeFactory.SQUARE);
        //Then
        assertEquals(28.0, square.getCircumference(), 0);
        assertEquals("The angular square", square.getName());
    }

    @Test
    void testFactoryRectangle() {
        //Given
        ShapeFactory factory = new ShapeFactory();
        //When
        Shape rectangle = factory.makeShape(ShapeFactory.RECTANGLE);
        //Then
        assertEquals(37.50, rectangle.getArea(), 0);
        assertEquals("The long rectangle", rectangle.getName());
    }
}
