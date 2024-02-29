package org.example.mvc.repository.impl;

import org.example.mvc.repository.OrderRepository;
import org.example.mvc.repository.entity.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRepositoryImpl implements OrderRepository {
    List<Order> orderList = new ArrayList<Order>( List.of(
            new Order(1561L, 5),
            new Order(1431L, 6),
            new Order(1565L, 8)
    ));

    public List<Order> findAll() {
        return orderList;
    }

    @Override
    public Order save(Order entity) {
        var index = orderList.indexOf(entity);
        if (index > 0) {
            orderList.set(orderList.indexOf(entity), entity);
        } else {
            orderList.add(entity);
        }
        return entity;
    }


    public Order findById(Long id) {
        for(Order obj : orderList) {
            if(obj.getId().equals(id)) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        for(Order obj: orderList) {
            if(obj.getId().equals(id)) {
                orderList.remove(obj);
                break;
            }
        }
    }
}
