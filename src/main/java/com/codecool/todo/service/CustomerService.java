package com.codecool.todo.service;

import com.codecool.todo.model.Customer;
import com.codecool.todo.repository.CustomerRepository;
import com.codecool.todo.utility.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public boolean checkPassword(String userProvidedPsw, String psw) {
        return Password.checkPassword(userProvidedPsw, psw);
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
        createConnection(beFriender, beFriended);
        createConnection(beFriended, beFriender);
    }

    public void createConnection(String beFriender, String beFriended){
        Customer customer1 = getCustomerByName(beFriender);
        Customer customer2 = getCustomerByName(beFriended);

        Set<Customer> friends = customer1.getFriends();

        friends.add(customer2);

        customer1.setFriends(friends);
        customerRepository.save(customer1);
    }

    public List<Customer> getPossibleFriends(String name){
        List<Customer> modifiedList = findAll();
        modifiedList.removeAll(friendsIncludingCustomer(name));
        return modifiedList;
    }
}
