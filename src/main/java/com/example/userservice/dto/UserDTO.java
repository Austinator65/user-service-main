package com.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDTO {

    String firstName;
    String lastName;
    String address;
    String city;
    String email;
    String password;
    String phoneNumber;

    public String toString() {
        return "Registration info: Username: " + this.email + " password: " + this.password;
    }
}
