package com.javaLearning.Training.RESTapis.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaLearning.Training.RESTapis.entities.UserEntity;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Long>{
    // Optional<> wrapper class has one disadv - cause problems in serialization cases
    // can also use exception handling in case entity is not found
    Optional<UserEntity> findByUsername(String username);
}
