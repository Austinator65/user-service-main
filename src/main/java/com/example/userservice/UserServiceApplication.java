package com.example.userservice;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.userservice.model.Role;
import com.example.userservice.model.UserLogin;
import com.example.userservice.repository.RoleRepository;
import com.example.userservice.repository.UserRepository;

@SpringBootApplication
public class UserServiceApplication {
	public UserLogin admin;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);

	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (roleRepository.findByAuthority("ADMIN").isPresent())
				return;

			Role adminRole = roleRepository.save(new Role("ADMIN"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			this.admin = new UserLogin("admin", passwordEncoder.encode("pass"));
			userRepository.save(admin);
		};
	}

}
