package com.javaLearning.Training.RESTapis.configfuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/user/home").setViewName("user");
        registry.addViewController("/admin/home").setViewName("admin");
        registry.addViewController("/login").setViewName("custom_login");
        registry.addViewController("/error").setViewName("error");
        

    }
}
