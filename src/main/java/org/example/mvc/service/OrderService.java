package org.example.mvc.service;


import org.example.mvc.repository.entity.Order;
import org.example.mvc.repository.impl.OrderRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepositoryImpl repository;

    public OrderService(OrderRepositoryImpl repository) {
        this.repository = repository;
    }

    public List<Order> findAll(){
        List<Order> obj = repository.findAll();
        return new ArrayList<>(obj);
    }

    public Order insertOrder(Order order) {
        Order entity = new Order();
        entity.setId(order.getId());
        entity.setPrice(order.getPrice());
        return repository.save(entity);
    }

    public Order findById(Long id) {
        Order order = repository.findById(id);
        return order;
    }

    public Order update(Long id, Order order) {
        Order obj = repository.findById(id);
        obj.setPrice(order.getPrice());
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
