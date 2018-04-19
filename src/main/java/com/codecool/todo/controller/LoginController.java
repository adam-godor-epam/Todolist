package com.codecool.todo.controller;

import com.codecool.todo.model.Customer;
import com.codecool.todo.service.CustomerService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpSession;

@Controller
@Scope("session")
public class LoginController {

    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/login")
    public String login(HttpServletRequest request, HttpSession session, Model model){
        Customer costumer = customerService.getCustomerByName(request.getParameter("name"));
        return "redirect:/todopage";
    }

    @PostMapping(value = "/register")
    public String regist(HttpServletRequest request, HttpSession session, Model model){
        customerService.save(request.getParameter("name"), request.getParameter("password"));
        return "redirect:/";
    }

    @GetMapping(value = "/")
    public String renderIndexPage(){
        return "indexpage";
    }

}
