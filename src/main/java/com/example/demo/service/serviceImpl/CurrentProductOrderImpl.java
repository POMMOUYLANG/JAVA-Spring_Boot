package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Current_product_order;
import com.example.demo.repository.CurrentProductOrderRepository;
import com.example.demo.service.CurrentProductOrderService;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductSizeService;

@Service
public class CurrentProductOrderImpl implements CurrentProductOrderService {
    private CurrentProductOrderRepository currentProductOrderRepository;
    private ProductService productService;
    private ProductSizeService productSizeService;

    public CurrentProductOrderImpl(CurrentProductOrderRepository currentProductOrderRepository, ProductService productService, ProductSizeService productSizeService) {
        super();
        this.currentProductOrderRepository = currentProductOrderRepository;
        this.productService = productService;
        this.productSizeService = productSizeService;
    }

    @Override
    public List<Current_product_order> getAllOrders() {
        return currentProductOrderRepository.findAll();
    }

    @Override
    public Current_product_order saveOrder(Current_product_order current_product_order) {
        return currentProductOrderRepository.save(current_product_order);
    }

    @Override
    public Current_product_order getOrderById(Integer id) {
        return currentProductOrderRepository.findById(id).get();
    }

    @Override
    public void deleteOrder(Integer id) {
        currentProductOrderRepository.deleteById(id);;
    }

    @Override
    public String getAllOrderIds() {
        String ids = "";
        for(Current_product_order order: currentProductOrderRepository.findAll()){
            ids = ids + order.getId() + ",";
        }
        ids = ids.substring(0, ids.length()-1);
        return ids;
    }

    @Override
    public Float getTotalPrice() {
        Float totalPrice = (float) 0;
        for(Current_product_order order: currentProductOrderRepository.findAll()){
            Float orderAmount = (float) order.getAmount();
            Float orderPrice = productService.getProductById( order.getProduct_id() ).getPrice();
            Float orderSizePrice = productSizeService.getSizeById(order.getSize_id()).getPrice();
            totalPrice = totalPrice + ( ( ( orderPrice + orderSizePrice ) * orderAmount ) );
        }
        return totalPrice;
    }

    @Override
    public void deleteAllOrders() {
        currentProductOrderRepository.deleteAll();;
    }

    @Override
    public Boolean isEmpty() {
        if(currentProductOrderRepository.count() == 0) {
            return true;
        }
        else{
            return false;
        }
    }
    
    
}
