package com.codecool.todo.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String psw;

    public Customer(String name, String psw){
        this.name = name;
        this.psw = psw;
    }

    public String getName() {
        return name;
    }
}