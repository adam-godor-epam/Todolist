package com.codecool.todo.service;

import com.codecool.todo.model.Customer;
import com.codecool.todo.model.Friendship;
import com.codecool.todo.repository.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendshipService {

    @Autowired
    FriendshipRepository friendshipRepository;

    public void save (Friendship friendship){
        friendshipRepository.save(friendship);
    }

}
