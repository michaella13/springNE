package com.example.springsecurityjwttutorial.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "Customer")
@Entity // Marks this class as an Entity
@Getter // Defines the getter methods of the member fields
@Setter // Defines the setter methods of the member fields
@ToString // Defines a meaningful toString implementation of this class
@NoArgsConstructor // Defines the default constructor
public class Customer {

    @Id // Marks the "id" field as the identifier of this entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // The "id" field is to be generated automatically
    private Long id;


    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    public Customer(String firstName, String phone, String email, String password) {
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
}
