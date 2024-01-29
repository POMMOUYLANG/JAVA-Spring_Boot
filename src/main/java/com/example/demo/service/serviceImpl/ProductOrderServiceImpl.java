package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product_order;
import com.example.demo.repository.ProductOrderRepository;
import com.example.demo.service.ProductOrderService;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    private ProductOrderRepository productOrderRepository;

    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository) {
        super();
        this.productOrderRepository = productOrderRepository;
    }


    @Override
    public List<Product_order> getAllOrders() {
        return productOrderRepository.findAll();
    }

    @Override
    public Product_order saveOrder(Product_order product_order) {
        return productOrderRepository.save(product_order) ;
    }


    @Override
    public Product_order getOrderById(Integer id) {
        return productOrderRepository.findById(id).get();
    }


    @Override
    public void deleteOrder(Integer id) {
        productOrderRepository.deleteById(id);
    }
    
}
