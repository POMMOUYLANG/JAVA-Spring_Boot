package com.example.demo.info;

import java.util.List;

import com.example.demo.model.Addons;
import com.example.demo.model.Current_product_order;
import com.example.demo.model.Product;
import com.example.demo.model.Product_size;

public class OrderInfo {
    private List<Addons> addonsList;
    private Product product;
    private Product_size size;
    private Current_product_order product_order;
    private Float orderPrice;

    public OrderInfo(List<Addons> addonsList, Product product, Product_size size, Current_product_order product_order) {
        this.addonsList = addonsList;
        this.product = product;
        this.size = size;
        this.product_order = product_order;
    } 

    public OrderInfo(Product product, Product_size size, Current_product_order product_order) {
        this.product = product;
        this.size = size;
        this.product_order = product_order;
    }    
    

    public OrderInfo(Product product, Product_size size) {
        this.product = product;
        this.size = size;
    }

    public List<Addons> getAddonsList() {
        return this.addonsList;
    }

    public void setAddonsList(List<Addons> addonsList) {
        this.addonsList = addonsList;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product_size getSize() {
        return this.size;
    }

    public void setSize(Product_size size) {
        this.size = size;
    }

    public Current_product_order getProduct_order() {
        return this.product_order;
    }

    public void setProduct_order(Current_product_order product_order) {
        this.product_order = product_order;
    }

    public Float getOrderPrice() {
        orderPrice = product.getPrice() + size.getPrice();
        return orderPrice;
    }
}
