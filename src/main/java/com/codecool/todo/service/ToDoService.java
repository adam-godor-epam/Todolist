package com.codecool.todo.service;

import com.codecool.todo.model.Todo;
import com.codecool.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    ToDoRepository toDoRepository;

    public void save(Todo todo){
        toDoRepository.save(todo);
    }
}
