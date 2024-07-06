package com.javaLearning.Training.RESTapis.configfuration;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.javaLearning.Training.RESTapis.entities.EmployeeEntity;
import com.javaLearning.Training.RESTapis.entities.UserEntity;
import com.javaLearning.Training.RESTapis.repositories.EmployeeRepository;
import com.javaLearning.Training.RESTapis.repositories.UserRepository;

@Configuration
public class DBconfig {
    private static final Logger Log=LoggerFactory.getLogger(DBconfig.class);

    // db initialisation using commandLineRunner

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDatabase(UserRepository repo, EmployeeRepository erepo) {
        return args -> {
            Log.info("Preload" + repo.save(new UserEntity(1L,"Vedant", passwordEncoder.encode("1234"), "USER,ADMIN")));
            Log.info("Preload" + repo.save(new UserEntity(2L,"Varun", passwordEncoder.encode("1234"), "USER")));
            Log.info("Preload" + erepo.save(new EmployeeEntity(1L,"Vedant", LocalDate.of(2024,07,01), true, "vedantnaudiyal@gmail.com", 21)));
            Log.info("Preload" + erepo.save(new EmployeeEntity(2L,"Abhishek", LocalDate.of(2024,07,01), true, "Abhishek@gmail.com", 21)));
            Log.info("Preload" + erepo.save(new EmployeeEntity(3L,"Varun", LocalDate.of(2024,07,01), true, "varun@gmail.com", 21)));
            Log.info("Preload" + erepo.save(new EmployeeEntity(4L,"Khyati", LocalDate.of(2024,07,01), true, "khyati@gmail.com", 21)));
        };
    }
}
