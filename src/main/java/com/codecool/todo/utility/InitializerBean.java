package com.codecool.todo.utility;

import com.codecool.todo.model.Customer;
import com.codecool.todo.model.Friendship;
import com.codecool.todo.model.Todo;
import com.codecool.todo.service.CustomerService;
import com.codecool.todo.service.FriendshipService;
import com.codecool.todo.service.ToDoService;
import org.springframework.stereotype.Component;

@Component
public class InitializerBean {

    public InitializerBean(CustomerService costumerService, FriendshipService friendshipService,
                           ToDoService toDoService) {

        Customer customer1 = new Customer("name", "psw");
        Customer customer2 = new Customer("name1", "psw1");
        Customer customer3 = new Customer("name2", "psw2");


        customer1.getFriends().add(customer2);
        customer2.getFriends().add(customer1);
        customer1.getFriends().add(customer3);
        customer3.getFriends().add(customer1);
        customer2.getFriends().add(customer3);

        Todo todo = new Todo(customer1, "do stuff");
        Todo todo1 = new Todo(customer1, "for real");
        Todo todo2 = new Todo(customer1, "todo", customer2);

        costumerService.save(customer1);
        costumerService.save(customer2);
        costumerService.save(customer3);

        toDoService.save(todo);
        toDoService.save(todo1);
        toDoService.save(todo2);

    }
}
