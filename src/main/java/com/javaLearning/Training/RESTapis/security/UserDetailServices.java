package com.javaLearning.Training.RESTapis.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javaLearning.Training.RESTapis.entities.UserEntity;
import com.javaLearning.Training.RESTapis.repositories.UserRepository;

// For using db users for authentication instead of memory managed users

@Service
public class UserDetailServices implements  UserDetailsService{

    // autowired dependency injection
    @Autowired
    UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<UserEntity> user=userRepository.findByUsername(username);
        if(user.isPresent()){
            var usrObj=user.get();
            return User
            .builder()
            .username(usrObj.getUsername())
            .password(usrObj.getPassword())
            .roles(getRoles(usrObj.getRole()))
            .build();
        }
        else{
            throw new UsernameNotFoundException(username);
        }
    }     
    
    public String[] getRoles(String roles){
        if(roles==null) return new String[]{"USER"};

        return roles.split(",");
    }
}
