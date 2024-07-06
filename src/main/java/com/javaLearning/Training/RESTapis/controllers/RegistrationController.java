package com.javaLearning.Training.RESTapis.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaLearning.Training.RESTapis.entities.UserEntity;
import com.javaLearning.Training.RESTapis.repositories.UserRepository;

@RestController
public class RegistrationController {

    final private UserRepository userRepository;
    final private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @PostMapping(path="/register/user")
    public UserEntity createNewUser(@RequestBody UserEntity user){
        System.out.println("post request made");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
