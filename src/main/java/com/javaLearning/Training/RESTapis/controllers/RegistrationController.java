package com.javaLearning.Training.RESTapis.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaLearning.Training.RESTapis.entities.UserEntity;
import com.javaLearning.Training.RESTapis.repositories.UserRepository;
import com.javaLearning.Training.RESTapis.security.JwtService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class RegistrationController {


    @Autowired
    JwtService jwtService;

    final private UserRepository userRepository;
    final private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @PostMapping(path="/register/user")
    public ResponseEntity<UserEntity> createNewUser(@RequestBody UserEntity user, HttpServletResponse response){
        System.out.println("post request made");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity u=userRepository.save(user);
        response.setHeader("authToken", jwtService.generateToken(user.getUsername()));
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    // @GetMapping(path="/logout")
    // public String logOutUser(HttpServletResponse response, HttpServletResponse response){
    //     System.out.println("post request made");
    //     user.setPassword(passwordEncoder.encode(user.getPassword()));
    //     UserEntity u=userRepository.save(user);
    //     response.setHeader("authToken", jwtService.generateToken(user.getUsername()));
    //     return new ResponseEntity<>(u, HttpStatus.CREATED);
    // }

    // public void usingHttpServletResponse(HttpServletResponse response){

    // }


}
