package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ProductDao extends CrudRepository<Product, Integer> {
}
