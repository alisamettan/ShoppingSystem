package org.example.repository;

import org.example.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    Customer save(Customer customer);
    List<Customer> findAll();
}