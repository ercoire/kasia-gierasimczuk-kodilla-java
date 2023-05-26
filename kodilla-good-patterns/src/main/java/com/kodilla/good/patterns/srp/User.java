package com.kodilla.good.patterns.srp;

public class User {

    private String name;
    private String familyName;

    public User(String name, String familyName) {
        this.name = name;
        this.familyName = familyName;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }
}
