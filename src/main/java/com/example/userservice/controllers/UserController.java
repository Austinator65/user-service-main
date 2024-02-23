package com.example.userservice.controllers;

import com.example.userservice.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin("/*")
public class UserController {

    @GetMapping()
    public String userCont() {

        return "User level";
    }

}
