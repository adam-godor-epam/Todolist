package com.codecool.todo.model;

import javax.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private String toDo;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Customer creator;

    public Todo(){}

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
