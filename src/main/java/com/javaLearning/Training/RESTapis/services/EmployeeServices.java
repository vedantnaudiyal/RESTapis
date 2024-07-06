package com.javaLearning.Training.RESTapis.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.javaLearning.Training.RESTapis.customExceptions.EmployeeNotFoundException;
import com.javaLearning.Training.RESTapis.dto.EmployeeDTO;
import com.javaLearning.Training.RESTapis.entities.EmployeeEntity;
import com.javaLearning.Training.RESTapis.repositories.EmployeeRepository;

@Service
public class EmployeeServices {

    final private EmployeeRepository employeeRepository;

    public EmployeeServices(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO getDTO(EmployeeEntity employeeEntity){
        return new EmployeeDTO(employeeEntity.getId(),employeeEntity.getName(), employeeEntity.getDateOfJoining(), employeeEntity.getIsActive(), employeeEntity.getEmail(), employeeEntity.getAge());
    } 

    public EmployeeEntity getEntity(EmployeeDTO employeeDTO){
        return new EmployeeEntity(employeeDTO.getId(),employeeDTO.getName(), employeeDTO.getDateOfJoining(), employeeDTO.getIsActive(), employeeDTO.getEmail(), employeeDTO.getAge());
    } 

    public EmployeeDTO getEmployeeById(Long id){
        // entity -> DTO
        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(id);
        
        // try{
        //     employeeEntity=employeeRepository.getReferenceById(id);
        // } catch(EntityNotFoundException e){
        //     System.out.println("it came here!");
        //     throw new EmployeeNotFoundException(id);
        // }

        // dealing with notfound scenario using optional and custom exceptions

        if(employeeEntity.isPresent()) return getDTO(employeeEntity.get());
        else throw new EmployeeNotFoundException(id);
    }
    
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO){
        // DTO -> entity
        EmployeeEntity employeeEntity = getEntity(employeeDTO);
        return getDTO(employeeRepository.save(employeeEntity));
    }

    public List<EmployeeDTO> getAllEmployees(){
        return employeeRepository.findAll().stream().map(employeeEntity -> getDTO(employeeEntity)).collect(Collectors.toList());
    }

    public boolean deleteEmployee(Long id){
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return true;
        }
        else throw new EmployeeNotFoundException(id);
    }
}
