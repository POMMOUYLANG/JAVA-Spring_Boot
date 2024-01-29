package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product_size;
import com.example.demo.repository.ProductSizeRepository;
import com.example.demo.service.ProductSizeService;

@Service
public class ProductSizeServiceImpl implements ProductSizeService {
    private ProductSizeRepository productSizeRepository;

    public ProductSizeServiceImpl(ProductSizeRepository productSizeRepository) {
        super();
        this.productSizeRepository = productSizeRepository;
    }

    @Override
    public Boolean isEmpty() {
        Long count = productSizeRepository.count();
        if(count>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Product_size saveProduct_size(Product_size product_size) {
        return productSizeRepository.save(product_size);
    }

    @Override
    public List<Product_size> getAllProductSizes() {
        return productSizeRepository.findAll();
    }

    @Override
    public Product_size getSizeById(Integer id) {
        return productSizeRepository.findById(id).get();
    }
    
}
