package com.kodilla.patterns2.facade;

import com.kodilla.patterns2.facade.api.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ShopServiceTestSuite {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderWatcher.class);

    @Autowired
    private ShopService shopService;

    @Autowired
    private OrderFacade orderFacade;


    @Test
    public void testShopFacade() {
        OrderDto order = new OrderDto();
        order.addItem(new ItemDto(10L, 2));
        order.addItem(new ItemDto(216L, 1));
        order.addItem(new ItemDto(25L, 1));
        order.addItem(new ItemDto(11L, 3));
        try {
            orderFacade.processOrder(order, 1L);
        } catch (OrderProcessingException e) {
            // business exception - should be handled in real application
        } LOGGER.info("Testing order processing method");
    }
}
