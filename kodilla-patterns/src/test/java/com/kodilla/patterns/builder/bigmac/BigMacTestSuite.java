package com.kodilla.patterns.builder.bigmac;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigMacTestSuite {

    @Test
    void testBigMacNew() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .bun("plain")
                .sauce("barbecue")
                .burgers(2)
                .ingredient("Red onion")
                .ingredient("Pickles")
                .ingredient("Bacon")
                .ingredient("Cheddar")
                .build();
        System.out.println(bigMac);
        //When
        int numberOfIngredients = bigMac.getIngredients().size();
        //Then
        assertEquals(4, numberOfIngredients);
        assertFalse(bigMac.getIngredients().contains("Pear"));
    }
}
