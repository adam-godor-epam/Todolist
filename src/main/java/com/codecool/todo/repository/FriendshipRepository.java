package com.codecool.todo.repository;

import com.codecool.todo.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, Integer> {


}
