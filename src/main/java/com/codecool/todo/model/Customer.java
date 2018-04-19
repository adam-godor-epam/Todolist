package com.codecool.todo.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String psw;

    @OneToMany(mappedBy = "friendshipRequester")
    private Set<Friendship> requestedFriends;

    @OneToMany(mappedBy = "friendshipReceiver")
    private Set<Friendship> receivedFriends;

    public Customer(String name, String psw){
        this.name = name;
        this.psw = psw;
    }

    public String getName() {
        return name;
    }

}
