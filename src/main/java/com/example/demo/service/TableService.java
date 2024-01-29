package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Table_seat;

public interface TableService {
    List<Table_seat> getAllTable();
    void setNewTableAmount(Integer tableAmount);
    Long getTableAmount();
    void setTableUnavaileble(Integer tabeID);
    void setTableAvaileble(Integer tabeID);
    
}
