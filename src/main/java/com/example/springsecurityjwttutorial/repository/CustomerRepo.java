package com.example.springsecurityjwttutorial.repository;

import com.example.springsecurityjwttutorial.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Defines a repository which provides an API or a list of helpful functions
// that helps us to work with the User entity
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    // Defines a custom method to find a User using the email attribute
    public Optional<Customer> findByEmail(String phone);
}
