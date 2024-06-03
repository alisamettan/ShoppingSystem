package org.example.repository;

import org.example.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository implements IOrderRepository{

    private List<Order> orders=new ArrayList<>();
    @Override
    public void save(Order order) {
        orders.add(order);
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }

    public Order findByOrderCode(String orderCode) {
        Optional<Order> optionalOrder = orders.stream()
                .filter(order -> order.getOrderCode().equals(orderCode))
                .findFirst();
        return optionalOrder.orElse(null);
    }
}