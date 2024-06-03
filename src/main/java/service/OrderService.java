package service;

import org.example.model.Order;
import org.example.model.Product;
import org.example.repository.OrderRepository;

import java.util.List;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order order){
        orderRepository.save(order);
        return order;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public double calculateOrderTotal(String orderCode) {
        Order order = orderRepository.findByOrderCode(orderCode);
        return order.getProductList().stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }


}