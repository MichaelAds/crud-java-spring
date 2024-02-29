package org.example.mvc.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.mvc.repository.entity.Order;
import org.example.mvc.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    private final OrderService orderService;

    private OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder() {
        List<Order> obj = orderService.findAll();
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        Order order = orderService.findById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<Order> insertOrder(@RequestBody Order order) {
        order = orderService.insertOrder(order);
        return ResponseEntity.ok(order);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order ) {
        order = orderService.update(id, order);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
    }


}
