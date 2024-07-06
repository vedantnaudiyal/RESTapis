package com.javaLearning.Training.RESTapis.configfuration;

// import java.net.http.HttpRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.javaLearning.Training.RESTapis.services.UserDetailServices;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    // constructor based dependency injection
    final private UserDetailServices userDetailServices;

    public SecurityConfiguration(UserDetailServices userDetailServices){
        this.userDetailServices=userDetailServices;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
        .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
        .headers(headerConfigurer -> headerConfigurer.frameOptions(frameOptions -> frameOptions.disable())) //changed
        .authorizeHttpRequests(requests->{
            requests.requestMatchers("/", "/home", "/register/**").permitAll();
            requests.requestMatchers("/user/**").hasRole("USER");
            requests.requestMatchers("/admin/**").hasRole("ADMIN");
            requests.requestMatchers(HttpMethod.GET, "/employees/**").hasAnyRole("USER", "ADMIN");
            requests.requestMatchers("/employees/**").hasRole("ADMIN");
            requests.anyRequest().authenticated();
        })
        .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.loginPage("/login").permitAll())
        .logout((logout) -> logout.permitAll())
        .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return userDetailServices;
    }   

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailServices);
        provider.setPasswordEncoder(passwordEncoder());
        return  provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // ----------------- Memory managed users (not in db) -----------------
    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails normalUser=User
    //                             .builder()
    //                             .username("nu")
    //                             // password -1234
    //                             .password("$2a$12$lCWy./YvV2uOgvVcE6rnBuTp20BhkAVacfgbIC762rg1XjDGokIP2")
    //                             .roles("USER")
    //                             .build();
    //     UserDetails adminUser=User.builder()
    //                             .username("au")
    //                             // admin password - 5678
    //                             .password("$2a$12$dTD9PFAMHAiR1O1sY7iw6.aZ7UjJFVCZeac6FaMnZFlcY164HFK3S")
    //                             .roles("ADMIN", "USER")
    //                             .build();
        
    //     return new InMemoryUserDetailsManager(normalUser, adminUser);
    // }

    


    // ------------------Not related(was just an example)-------------
    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http
    //         .authorizeHttpRequests((requests) -> requests
    //             .requestMatchers("/", "/home").permitAll()
    //             .anyRequest().authenticated()
    //         )
    //         .formLogin((form) -> form
    //             .loginPage("/login")
    //             .permitAll()
    //         )
    //         .logout((logout) -> logout.permitAll());

    //     return http.build();
    // }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails user =
    //             User
    //             .builder()
    //             .username("user")
    //             .password("$2a$12$cbHlfQOVWbXmo95QL.AGqOqwSQ3xxDHfacAjlr.JIW2fqhoGtay9m")
    //             .roles("USER")
    //             .build();

    //     return new InMemoryUserDetailsManager(user);
    // }
    
    
}
