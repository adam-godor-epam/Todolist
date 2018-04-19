package com.codecool.todo.repository;

import com.codecool.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<Todo, Integer>{

    List<Todo> findByCustomerId(int id);
}
