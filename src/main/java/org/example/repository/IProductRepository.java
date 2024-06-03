package org.example.repository;

import org.example.model.Product;

import java.util.List;

public interface IProductRepository {
    Product save(Product product);
    List<Product> findAll();
}