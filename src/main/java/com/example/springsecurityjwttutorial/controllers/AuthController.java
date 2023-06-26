package com.example.springsecurityjwttutorial.controllers;

import com.example.springsecurityjwttutorial.dto.CustomerDto;
import com.example.springsecurityjwttutorial.entity.Customer;
import com.example.springsecurityjwttutorial.exceptions.ResourceNotFound;
import com.example.springsecurityjwttutorial.dto.AuthResponse;
import com.example.springsecurityjwttutorial.dto.LoginCredentials;
import com.example.springsecurityjwttutorial.repository.CustomerRepo;
import com.example.springsecurityjwttutorial.security.JWTUtil;
import com.example.springsecurityjwttutorial.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController // Marks the class a rest controller
@RequestMapping("/api/auth") // Requests made to /api/auth/anything will be handles by this class
public class AuthController {

    // Injecting Dependencies
    @Autowired private CustomerRepo userRepo;
    @Autowired private JWTUtil jwtUtil;

    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired
    AuthService authService;

    // Defining the function to handle the POST route for registering a user
    @PostMapping("/register")
    public Customer registerHandler(@RequestBody CustomerDto customerDto){
        return authService.registerCustomer(customerDto);
    }

    // Defining the function to handle the POST route for logging in a user
    @PostMapping("/login")
    public AuthResponse loginHandler(@RequestBody LoginCredentials body){
        return authService.loginCustomer(body);
    }
}
