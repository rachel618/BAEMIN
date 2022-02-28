package com.example.demo.src.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private final OrderDao orderDao;
    @Autowired
    private final OrderProvider orderProvider;

    public OrderService(OrderDao orderDao, OrderProvider orderProvider) {
        this.orderDao = orderDao;
        this.orderProvider = orderProvider;
    }
}
