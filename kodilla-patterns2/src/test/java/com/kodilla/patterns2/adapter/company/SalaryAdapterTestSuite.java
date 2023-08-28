package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaryAdapterTestSuite {

    @Test
    public void testTotalSalary() {
        // Given
        Workers workers = new Workers();                      // stary system
        SalaryAdapter salaryAdapter = new SalaryAdapter();    // zastosowanie Adaptera
        // When
        double totalSalary = salaryAdapter.totalSalary(workers.getWorkers(), workers.getSalaries());   // metoda Adaptera
        // Then
        System.out.println(totalSalary);
        assertEquals(27750, totalSalary, 0);
    }

}