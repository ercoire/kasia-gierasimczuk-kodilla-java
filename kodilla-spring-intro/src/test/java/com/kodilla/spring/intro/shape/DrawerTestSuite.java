package com.kodilla.spring.intro.shape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DrawerTestSuite {
    @Test
    void testDoDrawingWithCircle() {
        //Given
        Circle circle = new Circle();

        //When
        Drawer drawer = new Drawer(circle);
        String result = drawer.doDrawing();

        //Then
        assertEquals("This is a circle.", result);
    }

    @Test
    void testDoDrawingWithTriangle() {
        //Given
        Triangle triangle = new Triangle();

        //When
        Drawer drawer = new Drawer(triangle);
        String result = drawer.doDrawing();

        //Then
        assertEquals("This is a triangle.", result);
    }
}
