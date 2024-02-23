package com.example.userservice.controllers;

import io.micrometer.core.ipc.http.HttpSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.userservice.dto.LoginDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.model.User;
import com.example.userservice.service.AuthenticationService;

import java.net.http.HttpClient;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserDTO body) {
        UserDTO user = new UserDTO(body.getFirstName(), body.getLastName(), body.getAddress(),
                body.getCity(), body.getEmail(),
                body.getPassword(), body.getPhoneNumber());
        System.out.println(body.getEmail());
        return authenticationService.registerUser(user);
    }

    @PostMapping("/login")
    public Object loginUser(@RequestBody LoginDTO login) {

        LoginDTO user = new LoginDTO(login.getEmail(), login.getPassword());
        authenticationService.loginUser(user);

        HttpClient.Redirect.valueOf("/user");
         return authenticationService.loginUser(user);

    }

}
