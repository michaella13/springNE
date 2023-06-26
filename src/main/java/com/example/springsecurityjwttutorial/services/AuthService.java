package com.example.springsecurityjwttutorial.services;

import com.example.springsecurityjwttutorial.dto.AuthResponse;
import com.example.springsecurityjwttutorial.dto.CustomerDto;
import com.example.springsecurityjwttutorial.dto.LoginCredentials;
import com.example.springsecurityjwttutorial.entity.Customer;
import com.example.springsecurityjwttutorial.exceptions.ResourceNotFound;
import com.example.springsecurityjwttutorial.repository.CustomerRepo;
import com.example.springsecurityjwttutorial.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    JWTUtil jwtUtil;

    @Autowired
    AuthenticationManager authManager;


    public Customer registerCustomer(CustomerDto customerDto) {


        // Encoding Password using Bcrypt
        String encodedPass = passwordEncoder.encode(customerDto.getPassword());

        Customer customer =
                new Customer(customerDto.getFirstName(), customerDto.getPhone(), customerDto.getEmail(), encodedPass);

        Customer savedCustomer = customerRepo.save(customer);

        return savedCustomer;
    }

    public AuthResponse loginCustomer(LoginCredentials body) {
        try {
            // Creating the Authentication Token which will contain the credentials for authenticating
            // This token is used as input to the authentication process
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());

            System.out.println("auth");
            // Authenticating the Login Credentials
            authManager.authenticate(authInputToken);
            System.out.println("input token");
            // If this point is reached it means Authentication was successful
            // Generate the JWT
            String token = jwtUtil.generateToken(body.getEmail());

            System.out.println(token);

            // Respond with the JWT with user

            Optional<Customer> customerOptional = customerRepo.findByEmail(body.getEmail());
            Customer authCustomer = customerOptional.get();

            AuthResponse authResponse = new AuthResponse(token, authCustomer);
            return authResponse;
        }catch (AuthenticationException authExc){
            authExc.printStackTrace();
            // Auhentication Failed
            throw new ResourceNotFound("Invalid Login Credentials");
        }
    }
}
