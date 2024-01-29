package com.example.demo.service.serviceImpl;

import java.util.List;

import com.example.demo.model.Table_seat;
import com.example.demo.repository.TableRepository;
import com.example.demo.service.TableService;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImpl implements TableService {
    private TableRepository tableRepository;
    private JdbcTemplate jdbcTemplate;

    public TableServiceImpl(TableRepository tableRepository, JdbcTemplate jdbcTemplate) {
        super();
        this.tableRepository = tableRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Table_seat> getAllTable() {
        return tableRepository.findAll();
    }

    @Override
    public void setNewTableAmount(Integer tableAmount) {
        Long rowsAmount = tableRepository.count();
        if(rowsAmount > tableAmount){
            for(int i=1; i<=rowsAmount; i++){
                if(i > tableAmount){
                    tableRepository.deleteById(i);
                }
            }
        }
        else if (rowsAmount < tableAmount){
            String sql = "ALTER TABLE table_seat AUTO_INCREMENT = 1";
            jdbcTemplate.execute(sql);
            for(int i = (int) (rowsAmount + 1); i<=tableAmount; i++){
                Table_seat newTable = new Table_seat();
                newTable.setNumber(i);
                newTable.setAvailability(1);
                tableRepository.save(newTable);
            }
        }
    }

    @Override
    public Long getTableAmount() {
        return tableRepository.count();
    }

    @Override
    public void setTableUnavaileble(Integer tabeID) {
        Table_seat table = tableRepository.findById(tabeID).get();
        table.setAvailability(0);
        tableRepository.save(table);

    }
    @Override
    public void setTableAvaileble(Integer tabeID) {
        Table_seat table = tableRepository.findById(tabeID).get();
        table.setAvailability(1);
        tableRepository.save(table);

    }

}
