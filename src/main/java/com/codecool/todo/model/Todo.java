package com.codecool.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Customer customer;
    private String toDo;
    private Customer creator;

    public Todo (Customer customer, String toDo){
        this.customer= customer;
        this.toDo = toDo;
        this.creator = customer;
    }

    public Todo (Customer customer, String toDo, Customer creator){
        this.customer = customer;
        this.toDo = toDo;
        this.creator = creator;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    public Customer getCreator() {
        return creator;
    }

}
