package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraMeatDecorator extends AbstractPizzaOrderDecorator{

    public ExtraMeatDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(10));
    }


    @Override
    public String getDescription() {
        return super.getDescription() + "+ more meat ";
    }
}
