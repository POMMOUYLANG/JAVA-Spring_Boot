package com.example.demo.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private Integer invoice_id;

    private Float cash_received;

    private Float cash_change;

    @CreationTimestamp
    private LocalDateTime created_at;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvoice_id() {
        return this.invoice_id;
    }

    public void setInvoice_id(Integer invoice_id) {
        this.invoice_id = invoice_id;
    }

    public Float getCash_received() {
        return this.cash_received;
    }

    public void setCash_received(Float cash_received) {
        this.cash_received = cash_received;
    }

    public Float getCash_change() {
        return this.cash_change;
    }

    public void setCash_change(Float cash_change) {
        this.cash_change = cash_change;
    }

    public LocalDateTime getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

}
