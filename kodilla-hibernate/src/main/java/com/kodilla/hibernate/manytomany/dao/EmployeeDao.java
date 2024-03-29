package com.kodilla.hibernate.manytomany.dao;


import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import java.util.List;


@Transactional
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query
    List<Employee> retrieveRequestedNames(@Param("LASTNAME") String lastname);

    @Query
    List<Employee> retrieveByText(@Param("text") String text);
}
