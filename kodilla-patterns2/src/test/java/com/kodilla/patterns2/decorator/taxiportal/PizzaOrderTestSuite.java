package com.kodilla.patterns2.decorator.taxiportal;

import com.kodilla.patterns2.decorator.pizza.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void shouldCheckBasicPizzaOrderGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal("15.00"), calculatedCost);
    }

    @Test
    public void shouldCheckBasicPizzaOrderGetDescription() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // When
        String description = theOrder.getDescription();
        // Then
        assertEquals("Margarita ", description);
    }

    @Test
    public void shouldCreateDescriptionPizzaWithExtraCheese() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Margarita + extra cheese ", description);
    }

    @Test
    public void shouldCreateDescriptionPizzaWithExtraCheeseAndVegetables() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new ExtraVegetablesDecorator(theOrder);
        //When
        String description = theOrder.getDescription();

        //Then
        assertEquals("Margarita + extra cheese + some veggies ", description);
    }

    @Test
    public void shouldCreateDescriptionPizzaWithAllExtras() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new ExtraVegetablesDecorator(theOrder);
        theOrder = new ExtraMeatDecorator(theOrder);

        //When
        String description = theOrder.getDescription();

        //Then
        assertEquals("Margarita + extra cheese + some veggies + more meat ", description);
    }

    @Test
    public void shouldGetCostPizzaWithExtraCheese() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        //When
        BigDecimal cost = theOrder.getCost();

        //Then
        assertEquals(new BigDecimal("22.00"), cost);
    }

    @Test
    public void shouldGetCostPizzaWithExtraCheeseAndVegetables() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new ExtraVegetablesDecorator(theOrder);

        //When
        BigDecimal cost = theOrder.getCost();

        //Then
        assertEquals(new BigDecimal("28.00"), cost);
    }

    @Test
    public void shouldGetCostPizzaWithAllExtras() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new ExtraVegetablesDecorator(theOrder);
        theOrder = new ExtraMeatDecorator(theOrder);

        //When
        BigDecimal cost = theOrder.getCost();

        //Then
        assertEquals(new BigDecimal("38.00"), cost);
    }
}
