package com.example.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userservice.model.User;

@Repository
public interface
UserLoginRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

  Optional<User> getUserByEmail(String email);
}
