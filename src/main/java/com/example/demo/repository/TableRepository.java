package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Table_seat;

public interface TableRepository extends JpaRepository<Table_seat, Integer> {
    
}
