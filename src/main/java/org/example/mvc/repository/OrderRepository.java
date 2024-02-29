package org.example.mvc.repository;

import org.example.mvc.repository.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository {
    List<Order> findAll();

    Order save(Order entity);

    Order findById(Long id);

    void delete(Long id);
}
