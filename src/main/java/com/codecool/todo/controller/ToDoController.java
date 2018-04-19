package com.codecool.todo.controller;

import com.codecool.todo.model.Customer;
import com.codecool.todo.service.CustomerService;
import com.codecool.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

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
        return "todopage";
    }
}
