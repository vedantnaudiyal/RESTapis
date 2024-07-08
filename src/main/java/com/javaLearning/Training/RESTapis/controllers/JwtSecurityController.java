package com.javaLearning.Training.RESTapis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaLearning.Training.RESTapis.dto.AuthRequestDTO;
import com.javaLearning.Training.RESTapis.services.JwtService;

@RestController
public class JwtSecurityController {
    
    // started using view for these endpoints so no more required!
    //  -------------------------------------------------

    // @GetMapping(path="/home")
    // public String getHomePublic(){
    //     return "home";
    // }

    // @GetMapping(path="/user/home")
    // public String getHomeUser(){
    //     return "hello";
    // }

    // @GetMapping(path="/admin/home")
    // public String getHomeAdmin(){
    //     return "hello!";
    // }
    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping(path = "/authenticate")
    public String auhenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO){
        // System.out.println("hello world!");

        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequestDTO.getUsername());
        }
        else throw new UsernameNotFoundException("No user with this name exists!");
    }
}
