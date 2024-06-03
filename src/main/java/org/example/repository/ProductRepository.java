package org.example.repository;

import org.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository implements IProductRepository{

    private List<Product> products=new ArrayList<>();
    @Override
    public Product save(Product product) {
         products.add(product);
         return product;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}