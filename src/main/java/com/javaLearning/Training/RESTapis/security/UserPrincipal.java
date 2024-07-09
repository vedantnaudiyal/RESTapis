package com.javaLearning.Training.RESTapis.security;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.javaLearning.Training.RESTapis.entities.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPrincipal implements UserDetails{
    private Long id;
    private String username;
    private String password;
    private java.util.Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(UserEntity user) {
        List<GrantedAuthority> authorities = Collections.
                singletonList(new SimpleGrantedAuthority("ROLE_USER"));

        return new UserPrincipal(
                user.getUser_id(),
                user.getUsername(),
                user.getPassword(),
                authorities
            );
    }
}


