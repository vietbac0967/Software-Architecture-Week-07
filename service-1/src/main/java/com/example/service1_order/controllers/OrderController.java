package com.example.service1_order.controllers;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.service1_order.models.Order;
import com.example.service1_order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getLisOrder() {
        return orderService.getListOrder();
    }

    @GetMapping("/orders/{id}")
    public Order getUserById(@PathVariable(value = "id") long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @DeleteMapping("/orders/{orderId}")
    public void deleteOrder(@PathVariable(value = "orderId") long orderId) {
        orderService.deleteOrderById(orderId);
    }
}
