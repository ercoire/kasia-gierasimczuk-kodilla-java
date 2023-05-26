package com.kodilla.good.patterns.challenges;

public class SportEquiment extends Material {

    private final String sportType;

    public SportEquiment(String materialID, double price, int stockCount, String sportType) {
        super(materialID, price, stockCount);
        this.sportType = sportType;
    }

    public String getSportType() {
        return sportType;
    }


}
