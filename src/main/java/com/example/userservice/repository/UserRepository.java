package com.example.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userservice.model.UserLogin;

@Repository
public interface UserRepository extends JpaRepository<UserLogin, Integer> {

    Optional<UserLogin> findByEmail(String email);
}
