package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Current_product_order;

public interface CurrentProductOrderService {
    List<Current_product_order> getAllOrders();
    Current_product_order saveOrder(Current_product_order current_drink_order);
    Current_product_order getOrderById(Integer id);
    void deleteOrder(Integer id);
    String getAllOrderIds();
    Float getTotalPrice();
    void deleteAllOrders();
    Boolean isEmpty();
}
