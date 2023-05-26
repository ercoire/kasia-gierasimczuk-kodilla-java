package com.kodilla.good.patterns.srp;

public class RentalDto {
    private User user;
    private boolean isRented;

    public RentalDto(final User user, final boolean isRented) {
        this.user = user;
        this.isRented = isRented;
    }

    public User getUser() { return user; }

    public boolean isRented() { return isRented; }
}
