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
    private int userId;
    private String toDo;
    private int creatorId;

    public Todo (int userId, String toDo){
        this.userId = userId;
        this.toDo = toDo;
        this.creatorId = userId;
    }

    public Todo (int userId, String toDo, int creatorId){
        this.userId = userId;
        this.toDo = toDo;
        this.creatorId = creatorId;
    }

    public int getUserId() {
        return userId;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    public int getCreatorId() {
        return creatorId;
    }



}
