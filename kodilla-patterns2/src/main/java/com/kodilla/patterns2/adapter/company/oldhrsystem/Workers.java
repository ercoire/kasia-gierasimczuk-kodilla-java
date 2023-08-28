package com.kodilla.patterns2.adapter.company.oldhrsystem;

public class Workers {

    private String[][] workers = {
            {"67032906720", "John", "Smith"},
            {"62081612187", "Ivone", "Novak"},
            {"75021310799", "Jessie", "Pinkman"},
            {"75012200766", "Walter", "White"},
            {"75073006831", "Clara", "Lanson"}};

    private double[] salaries = {
            4500.00,
            3700.00,
            4350.00,
            9000.00,
            6200.00};

    public String getWorker(int n) {
        if (n > salaries.length) {
            return "";
        }
        return workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2] + ", " + salaries[n];
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }

}
