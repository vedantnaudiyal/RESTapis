package com.javaLearning.Training.RESTapis.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

// GET /EMPLOYEE
// GET /EMPLOYEE
// POST /EMPLOYEE
// DELETE /EMPLOYEE
// PUT /EMPLOYEE
// PATCH /EMPLOYEE

// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.javaLearning.Training.RESTapis.dto.AuthRequestDTO;
import com.javaLearning.Training.RESTapis.dto.EmployeeDTO;
import com.javaLearning.Training.RESTapis.services.EmployeeServices;
import com.javaLearning.Training.RESTapis.services.JwtService;

import jakarta.validation.Valid;

// import jakarta.validation.Valid;

// import jakarta.websocket.server.PathParam;

// import java.time.LocalDate;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController{

    private final EmployeeServices employeeServices;
    private final JwtService jwtService;

    public EmployeeController(EmployeeServices employeeServices, JwtService jwtService){
        this.employeeServices=employeeServices;
        this.jwtService= jwtService;
    }

    // path variables - url params(mandatory to provide)
    @GetMapping(path="/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") Long employee_id){
        // using the id in url to create an employee
        return new ResponseEntity<>(employeeServices.getEmployeeById(employee_id), HttpStatus.OK);
        // return new EmployeeDTO( employee_id, "Vedant Naudiyal", LocalDate.of(2002, 07, 01), true);
    }

    // GET ALL EMPLOYEES
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        return new ResponseEntity<>(employeeServices.getAllEmployees(), HttpStatus.OK);
    }

    // path parameters - url queries(optional to provide) can'ot rename path parameters
    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(
        // @PathParam("name") String name,
        // @PathParam("id") Integer id,
        // @PathParam("dt") LocalDate dt
        @Valid @RequestBody EmployeeDTO employeeDTO
    ){
        return new ResponseEntity<>(employeeServices.createNewEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Boolean> deleteEmployee(
        @PathVariable Long id
    ){
        return new ResponseEntity<>(employeeServices.deleteEmployee(id), HttpStatus.OK);
    }

}
