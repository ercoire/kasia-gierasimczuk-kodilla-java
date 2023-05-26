package com.kodilla.good.patterns.challenges;

public class Customer {

    private final String customerID;

    public Customer(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerID() {
        return customerID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return customerID.equals(customer.customerID);
    }

    @Override
    public int hashCode() {
        return customerID.hashCode();
    }
}
