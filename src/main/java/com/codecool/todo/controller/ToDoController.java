package com.codecool.todo.controller;

import com.codecool.todo.model.Customer;
import com.codecool.todo.model.Todo;
import com.codecool.todo.service.CustomerService;
import com.codecool.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/todopage")
    public String renderTodoPage(HttpSession session, Model model){
        Customer customer = customerService.getCustomerByName(session.getAttribute("name").toString());
        model.addAttribute("todos", toDoService.getAllTodo(customer.getId()));
        List<Customer> friends = new ArrayList<>();
        friends.add(customerService.getCustomerByName("name1"));
        friends.add(customerService.getCustomerByName("name"));
        model.addAttribute("friends", friends);
        return "todopage";
    }

    @PostMapping(value = "/addtodo")
    public String addToDo(HttpServletRequest request, HttpSession session){
        Todo todo = new Todo(customerService.getCustomerByName(request.getParameter("friend")),
                            request.getParameter("newtodo"),
                            customerService.getCustomerByName(session.getAttribute("name").toString()));
        toDoService.save(todo);
        return "redirect:/todopage";
    }

}
