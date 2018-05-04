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

@Controller
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @Autowired
    CustomerService customerService;

    //todo create a check if user is not logged in so it wont return with 500 status code
    //if user is null return 403
    @GetMapping(value = "/todopage")
    public String renderTodoPage(HttpSession session, Model model) {
        String userName = (String) session.getAttribute("name");
        Customer customer = customerService.getCustomerByName(userName);
        model.addAttribute("todos", toDoService.getAllTodo(customer.getId()));
        model.addAttribute("friends", customerService.friendsIncludingCustomer(userName));
        model.addAttribute("customers", customerService.getPossibleFriends(userName));
        model.addAttribute("hasPossibleFriends", customerService.getPossibleFriends(userName).size());
        return "todopage";
    }

    @PostMapping(value = "/addtodo")
    public String addToDo(HttpServletRequest request, HttpSession session) {
        Todo todo = new Todo(customerService.getCustomerByName(request.getParameter("friend")),
                request.getParameter("newtodo"),
                customerService.getCustomerByName(session.getAttribute("name").toString()));
        toDoService.save(todo);
        return "redirect:/todopage";
    }
}
