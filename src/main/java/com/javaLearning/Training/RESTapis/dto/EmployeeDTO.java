package com.javaLearning.Training.RESTapis.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    @NotBlank(message = "Name is mandatory")
    @Size(max=20, min=4, message = "Name must be >= 4 characters and <= 20 characters!")
    private String name;
    @Past(message = "Date of joining should be a past date!")
    private LocalDate dateOfJoining;
    @NotNull(message="Active status is mandatory!")
    private Boolean isActive;
    @NotBlank(message = "Email address is mandatory!!")
    @Email(message = "Pls enter a valid email address!")
    private String email;
    
    @NotNull(message = "Age is mandatory!!")
    @Min(value = 16, message = "Underage!")
    @Max(value = 60, message = "Overage!")
    private Integer age;


    // public LocalDate getDateOfJoining() {
    //     return dateOfJoining;
    // }
    // public Long getId() {
    //     return id;
    // }
    // public String getName() {
    //     return name;
    // }
    // public Boolean getIsActive() {
    //     return isActive;
    // }

    // public void setDateOfJoining(LocalDate dateOfJoining) {
    //     this.dateOfJoining = dateOfJoining;
    // }
    // public void setId(Long id) {
    //     this.id = id;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }
    // public void setIsActive(Boolean isActive) {
    //     this.isActive = isActive;
    // }

}
