package org.example.repository;

import org.example.model.Order;

import java.util.List;

public interface IOrderRepository {
    void save(Order order);
    List<Order> findAll();
    Order findByOrderCode(String orderCode);
}