package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskFactoryTestSuite {


    @Test
    void testFactoryShopping() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.makeTask(TaskFactory.SHOPPING);

        //Then
        assertTrue(shopping.isTaskExecuted());
        assertEquals("Spending some money on things.", shopping.getTaskName());
    }

    @Test
    void testFactoryPainting() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.makeTask(TaskFactory.PAINTING);

        //Then
        assertTrue(painting.isTaskExecuted());
        assertEquals("I'm making a piece of art!", painting.executeTask());
    }


    @Test
    void testFactoryDriving() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.makeTask(TaskFactory.DRIVING);

        //Then
        assertEquals("Going on an adventure.", driving.getTaskName());
        assertTrue(driving.isTaskExecuted());

    }
}
