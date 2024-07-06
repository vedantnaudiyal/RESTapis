package com.javaLearning.Training.RESTapis.customExceptions;


public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id){
        super("Employee not found with id " + id);
    }
}
