package com.codecool.todo.controller;

import com.codecool.todo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpRequest;
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
        System.out.println("friendshipcontroller");
        System.out.println((String) session.getAttribute("name"));
        System.out.println(request.getParameter("name"));
        customerService.addFriend((String) session.getAttribute("name"), request.getParameter("name"));
        return "redirect:/todopage";
    }
}
