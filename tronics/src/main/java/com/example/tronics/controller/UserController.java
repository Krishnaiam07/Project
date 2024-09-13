package com.example.tronics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tronics.model.Users;
import com.example.tronics.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);

    }
    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        System.out.println("Attempting to authenticate user: " + user.getUsername());
        return service.verify(user);
    }

}