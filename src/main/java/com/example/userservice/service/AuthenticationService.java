package com.example.userservice.service;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.userservice.dto.LoginDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.model.Role;
import com.example.userservice.model.User;
import com.example.userservice.model.UserLogin;
import com.example.userservice.repository.RoleRepository;
import com.example.userservice.repository.UserLoginRepository;
import com.example.userservice.repository.UserRepository;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(UserDTO user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        User person = new User(user.getFirstName(), user.getLastName(), user.getAddress(),
                user.getCity(), user.getEmail(), user.getPhoneNumber());
       // Role userRole = roleRepository.findByAuthority("USER").get();
        System.out.println(user.getFirstName());
      //  Set<Role> authorities = new HashSet<>();
       // authorities.add(userRole);
        userLoginRepository.save(person);
        userRepository.save(new UserLogin(user.getEmail(), encodedPassword, person.getUserId()));

        return person;
    }

    public Object loginUser(LoginDTO user) {

         String encodedPassword = passwordEncoder.encode(user.getPassword());

        if (userRepository.findByEmail(user.getEmail()).isPresent() || userRepository.findByPassword(encodedPassword).isPresent()) {
            System.out.println("User Logged in");
           // Role userRole = roleRepository.findByAuthority("USER").get();
          //  System.out.println(userRole);
            System.out.println("Login successfully");

            return userLoginRepository.getUserByEmail(user.getEmail());
        } else {
            System.out.println("User not found");
            return null;
        }
    }

}
