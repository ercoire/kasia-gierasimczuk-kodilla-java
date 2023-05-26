package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;


public class Groceries extends Material {

    private final String category;
    private final LocalDate expirationDate;


    public Groceries(String materialID, double price, int stockCount, String category, LocalDate expirationDate) {
        super(materialID, price, stockCount);
        this.category = category;
        this.expirationDate = expirationDate;
    }

    public String getCategory() {
        return category;
    }


    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    }
