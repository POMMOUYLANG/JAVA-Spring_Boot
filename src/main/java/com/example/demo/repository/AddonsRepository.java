package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Addons;

public interface AddonsRepository extends JpaRepository<Addons, Integer> {
    Addons findByName(String name);
    List<Addons> findMultipleByName(String name);
}
