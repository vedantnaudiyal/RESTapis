package com.javaLearning.Training.RESTapis.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.javaLearning.Training.RESTapis.customExceptions.EmployeeNotFoundException;

// import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArguments(MethodArgumentNotValidException e){
        Map<String,String> mp=new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error -> {
            mp.put(error.getField(), error.getDefaultMessage());
        });
        return mp;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleNotFound(EmployeeNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> authenticationException(AuthenticationException e){
        System.out.println("    \nauthentiaction excepiton arised!\n");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // @ResponseStatus(HttpStatus.NOT_FOUND)
    // @ExceptionHandler(EntityNotFoundException.class)
    // public ResponseEntity<String> EntityNotFound(EntityNotFoundException ex){
    //     return new ResponseEntity<>("Entity not found!", HttpStatus.NOT_FOUND);
    // }

}
