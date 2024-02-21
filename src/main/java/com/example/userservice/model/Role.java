package com.example.userservice.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "role")
public class Role implements GrantedAuthority {

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "userId", referencedColumnName = "userId")
//    private User user;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleId")
    private Integer roleID;



    private String authority;


    public Role(String authority) {
        this.authority = authority;

    }


    @Override
    public String getAuthority() {
        return this.authority;
    }
}
