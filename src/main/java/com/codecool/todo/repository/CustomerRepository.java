package com.codecool.todo.repository;


import com.codecool.todo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByName(String name);

}