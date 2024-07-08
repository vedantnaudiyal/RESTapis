package com.javaLearning.Training.RESTapis.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long user_id;
    @Column(unique = true)
    private String username;

    // @Column(unique = true, length=100, nullable=false)
    // private String email;
    
    private String password;
    private String role;    // , separated values of roles if multiple like : "USER, ADMIN"
}