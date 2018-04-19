package com.codecool.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @PostMapping(value = "/login")
    public String login(){
        return "redirect:/todopage";
    }

    @GetMapping(value = "/todopage")
    public String renderTodoPage(){
        return "todopage";
    }
}
