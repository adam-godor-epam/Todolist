package com.codecool.todo.service;

import com.codecool.todo.model.Customer;
import com.codecool.todo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomerByName(String name) {
        return customerRepository.findByName(name);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public boolean checkPassword(String name, String psw) {
        if (getCustomerByName(name).getPsw().equals(psw)) {
            return true;
        } else {
            return false;
        }
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public List<Customer> findFriends(String name) {
        return customerRepository.findFriends(name);
    }

    public List<Customer> friendsIncludingCustomer(String name){
        List<Customer> customerList = new ArrayList<>();
        customerList.add(getCustomerByName(name));
        for (Customer customer : findFriends(name)){
            customerList.add(customer);
        }
        return customerList;
    }

    public void addFriend(String beFriender, String beFriended){
        Customer cust1 = getCustomerByName(beFriender);
        Customer cust2 = getCustomerByName(beFriended);
        cust1.getFriends().add(cust2);
        cust2.getFriends().add(cust1);
    }
}
