package com.codecool.todo.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    private String name;
    private String psw;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="friends")
    @JoinColumn(name="person_A_id", referencedColumnName="id")
    private List<Customer> friends = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<Todo> todos;
    public Customer(String name, String psw){
        this.name = name;
        this.psw = psw;
    }

    public Customer() {
    }

    public List<Customer> getFriends() {
        return friends;
    }

    public String getPsw() {
        return psw;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
