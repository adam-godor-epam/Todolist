package com.codecool.todo.repository;


import com.codecool.todo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByName(String name);

    @Query("SELECT friends FROM Customer c Where c.name = ?1")
    List<Customer> findFriends(String name);
}