package com.kodilla.patterns2.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final ProductService productService;
    private final List<Item> items = new ArrayList<>();
    private final Long orderId;
    private final Long userId;
    private boolean isPaid;
    private boolean isVerified;
    private boolean isSubmitted;

    public Order(Long orderId, Long userId, ProductService productService) {
        this.orderId = orderId;
        this.userId = userId;
        this.productService = productService;
    }


    public BigDecimal calculateValue() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Item item : items) {
            sum = sum.add(productService.getPrice(item.getProductId())
                    .multiply(BigDecimal.valueOf(item.getQty())));
        }
        return sum;
    }

    public List<Item> getItems() { return items; }

    public Long getOrderId() { return orderId; }

    public Long getUserId() { return userId; }

    public boolean isPaid() { return isPaid; }

    public void setPaid(boolean paid) { isPaid = paid; }

    public boolean isVerified() { return isVerified; }

    public void setVerified(boolean verified) { isVerified = verified; }

    public boolean isSubmitted() { return isSubmitted; }

    public void setSubmitted(boolean submitted) { isSubmitted = submitted; }
}