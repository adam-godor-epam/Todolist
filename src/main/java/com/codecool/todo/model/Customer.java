package com.codecool.todo.model;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customer")
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
    @OneToMany(mappedBy = "customer")
    private List<Todo> todos;

    public Customer(String name, String psw){
        this.name = name;
        this.psw = psw;
    }

    public Customer() {
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
