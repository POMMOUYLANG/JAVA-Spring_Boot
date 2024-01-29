package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    private String first_name;

    private String last_name;

    private String sex;

    private String password;

    private Date date_of_birth;

    @Column(unique=true)
    private String username;

    private String role;

    @CreationTimestamp
    private LocalDateTime created_at;

    @Lob
    @Column(nullable = false, length = 2147483647)
    private String image;


    public User() {
    }

    public User(String first_name, String last_name, String sex, String password, Date date_of_birth, String username, String role, String image) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.sex = sex;
        this.password = password;
        this.date_of_birth = date_of_birth;
        this.username = username;
        this.role = role;
        this.image = image;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate_of_birth() {
        return this.date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }


    public boolean isEmpty(){
        if(first_name.isEmpty() || last_name.isEmpty() || username.isEmpty() || password.isEmpty() || role.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean hasRole(String role){
        if(this.role.equals(role)){
            return true;
        }
        return false;
    }
}
