package com.codecool.todo.repository;

import com.codecool.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Todo, Integer>{


}
