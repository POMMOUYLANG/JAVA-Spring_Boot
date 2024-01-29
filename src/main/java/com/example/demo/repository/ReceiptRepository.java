package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
    
}
