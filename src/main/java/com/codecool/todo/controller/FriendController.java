package com.codecool.todo.controller;

import com.codecool.todo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class FriendController {

    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/addnewfriend")
    public String newFriend(HttpSession session, HttpServletRequest request){
        customerService.addFriend((String) session.getAttribute("name"), request.getParameter("name"));
        return "redirect:/todopage";
    }
}
