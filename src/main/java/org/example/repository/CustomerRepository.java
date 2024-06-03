package org.example.repository;

import org.example.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository{

    private List<Customer> customers=new ArrayList<>();

    public Customer save(Customer customer){
        customers.add(customer);
        return customer;
    }

    public List<Customer> findAll(){
        return customers;
    }
}
