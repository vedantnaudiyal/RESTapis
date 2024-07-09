package com.javaLearning.Training.RESTapis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaLearning.Training.RESTapis.repositories.UserRepository;

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

    // @Autowired
    // private UserRepository userRepository;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @PostMapping(path = "/authenticate")
    public String auhenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO){
        // System.out.println("hello world!");

        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequestDTO.getUsername());
        }
        else throw new UsernameNotFoundException("Invalid credentials!");
    }

    @GetMapping(path="/me")
    public UserDetails getUserDetails(Authentication authentication){
        UserDetails userDetails=(UserDetails)authentication.getPrincipal();
        System.out.println("User details are" + "/n" + userDetails.getUsername() + "/n" + userDetails.getAuthorities());
        return userDetails;
    }
}
