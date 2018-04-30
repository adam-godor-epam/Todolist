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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="friends", joinColumns = @JoinColumn(name="person_A_id", referencedColumnName="id"), inverseJoinColumns = @JoinColumn(name="person_B_id", referencedColumnName="id"))
    private Set<Customer> friends = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private List<Todo> todos;
    public Customer(String name, String psw){
        this.name = name;
        this.psw = psw;
    }


    public Customer() {
    }

    public Set<Customer> getFriends() {
        return friends;
    }

    public void setFriends(Set<Customer> friends) {
        this.friends = friends;
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
