package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarkson = new Employee("Stephanie", "Clarkson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarkson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarkson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testNamedQueries() {
        //Given
        Company securitySecretService = new Company("Security Secret Service");
        Company jonesUnlimited = new Company("Jones Unlimited");
        Company secureOperations = new Company("Secure Operations");

        //When
        companyDao.save(securitySecretService);
        companyDao.save(jonesUnlimited);
        companyDao.save(secureOperations);

        List<Company> companiesWithSelectedText = companyDao.retrieveCompaniesWithSelectedText("sec");

        //Then
        assertEquals(2, companiesWithSelectedText.size());

        //CleanUp
        try {
            companyDao.deleteById(securitySecretService.getId());
            companyDao.deleteById(jonesUnlimited.getId());
            companyDao.deleteById(secureOperations.getId());
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testNativeQueries() {

        //Given
        Employee adamSmith = new Employee("Adam", "Smith");
        Employee amberWagner = new Employee("Amber", "Wagner");
        Employee hannahFrost = new Employee("Hannah", "Frost");
        Employee aliceFrost = new Employee("Alice", "Frost");
        Employee peterFrost = new Employee("Peter", "Frost");

        //When
        employeeDao.save(adamSmith);
        employeeDao.save(amberWagner);
        employeeDao.save(hannahFrost);
        employeeDao.save(aliceFrost);
        employeeDao.save(peterFrost);

        List<Employee> retrieveRequestedNames = employeeDao.retrieveRequestedNames("Frost");

        //Then
        assertEquals(3, retrieveRequestedNames.size());

        //CleanUp
        try {
            employeeDao.deleteById(adamSmith.getId());
            employeeDao.deleteById(amberWagner.getId());
            employeeDao.deleteById(hannahFrost.getId());
            employeeDao.deleteById(aliceFrost.getId());
            employeeDao.deleteById(peterFrost.getId());
        } catch (Exception e) {
            //do nothing
        }
    }
}
