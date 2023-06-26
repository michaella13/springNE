package com.example.springsecurityjwttutorial.dto;

import com.example.springsecurityjwttutorial.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private Customer user;
}
