package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product_order;

public interface ProductOrderService {
    List<Product_order> getAllOrders();
    Product_order saveOrder(Product_order drink_order);
    Product_order getOrderById(Integer id);
    void deleteOrder(Integer id);
}
