package com.codecool.todo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Friendship implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Customer friendshipRequester;
    @ManyToOne
    private Customer friendshipReceiver;

    public Friendship (Customer friendshipRequester, Customer friendshipReceiver){
        this.friendshipRequester = friendshipRequester;
        this.friendshipReceiver = friendshipReceiver;
    }



}
