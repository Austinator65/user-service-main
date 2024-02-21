package com.example.userservice.service;

import java.util.HashSet;
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

       // Role userRole = roleRepository.findByAuthority("USER").get();
        System.out.println(user.getFirstName());
      //  Set<Role> authorities = new HashSet<>();
       // authorities.add(userRole);
        userRepository.save(new UserLogin(user.getEmail(), encodedPassword));
        return userLoginRepository.save(new User(0, user.getFirstName(), user.getLastName(), user.getAddress(),
                user.getCity(), user.getEmail(), user.getPhoneNumber()));
    }

    public void loginUser(LoginDTO user) {
        // String encodedPassword = passwordEncoder.encode(user.getPassword());

        if (userLoginRepository.findByEmail(user.getEmail()).isPresent()) {
            Role userRole = roleRepository.findByAuthority("USER").get();
            System.out.println(userRole);
        } else {
            System.out.println("User not found");
        }
        ;

        // return userRepository.save(new AppUser(0, user.getEmail(), encodedPassword,
        // authorities));
    }

}
