package com.javaLearning.Training.RESTapis.configfuration;

// import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javaLearning.Training.RESTapis.DB;
import com.javaLearning.Training.RESTapis.DevDB;
// import com.javaLearning.Training.RESTapis.PrdDB;

@Configuration
public class AppConfig {
    // two ways to provide different implementation of beans without causing ambiguity 
    // creating profiles and 
    // @Bean
    // @ConditionalOnProperty(name = "project.node", havingValue = "production", matchIfMissing = true)
    // public DB getPrdDBBean() {
    //     return new PrdDB();
    // }
    

    // @Bean
    // @ConditionalOnProperty(name = "project.mode", havingValue = "development")
    // public DB getDevDBBean() {
    //     return new DevDB();
    // }

    @Bean
    public DB getDevDBBean() {
        return new DevDB();
    }

}
