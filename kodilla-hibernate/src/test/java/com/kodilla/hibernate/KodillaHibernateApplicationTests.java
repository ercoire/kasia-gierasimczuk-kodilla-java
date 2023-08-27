package com.kodilla.hibernate;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.CompanyFacade;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class KodillaHibernateApplicationTests {

    @Autowired
    CompanyFacade companyFacade;

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    void shouldRetrieveCompaniesByText(){
        //Given
        Company appliances = new Company("Best Appliances");
        Company applications = new Company("New Applications");
        Company nova = new Company("Nova Products");
        companyDao.save(appliances);
        companyDao.save(applications);
        companyDao.save(nova);

        String text = "app";
        //When
        List<Company> actual = companyFacade.fetchCompaniesByText(text);

        //Then
        assertEquals(2, actual.size());
        assertEquals(appliances.getName(), actual.get(0).getName());

    }

    @Test
    void shouldRetrieveEmployeesByText(){
        //Given
        Employee emp1 = new Employee("James", "Smith");
        Employee emp2 = new Employee("Julia", "StJames");
        Employee emp3 = new Employee("Julia", "Brown");
        employeeDao.save(emp1);
        employeeDao.save(emp2);
        employeeDao.save(emp3);

        String text = "James";
        //When
        List<Employee> actual = companyFacade.fetchEmployeesByText(text);

        //Then
        assertEquals(2, actual.size());
        assertFalse(actual.contains(emp3));
    }


}
