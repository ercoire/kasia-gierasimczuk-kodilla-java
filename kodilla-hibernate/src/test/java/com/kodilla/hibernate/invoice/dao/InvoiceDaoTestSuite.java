package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave(){
        //Given
        Invoice invoice = new Invoice("01/2023");
        Product product1 = new Product("product1");
        Product product2 = new Product("product2");
        Item item1 = new Item(product1, new BigDecimal(100), 2, new BigDecimal(200));
        Item item2 = new Item(product2, new BigDecimal(30), 5, new BigDecimal(150));
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        product1.getItems().add(item1);
        product2.getItems().add(item2);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();
        Optional<Invoice> actual = invoiceDao.findById(id);

        //Then
        Assertions.assertTrue(actual.isPresent());
        Invoice result = actual.get();
        Assertions.assertEquals(result.getNumber(), invoice.getNumber());

        //CleanUp
        invoiceDao.deleteById(id);
    }
}
