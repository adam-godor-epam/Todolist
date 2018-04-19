package com.codecool.todo.service;

import com.codecool.todo.model.Customer;
import com.codecool.todo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomerByName(String name){
        return customerRepository.findByName(name);
    }

    public void save(Customer customer){
        customerRepository.save(customer);
    }

    public boolean checkPasword(String name, String psw){
        if(getCustomerByName(name).getPsw().equals(psw)){
            return true;
        } else {
            return false;
        }
    }


}
