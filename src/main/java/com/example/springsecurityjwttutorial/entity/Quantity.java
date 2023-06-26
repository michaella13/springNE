package com.example.springsecurityjwttutorial.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Quantity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(
            mappedBy = "quantity",
            cascade = CascadeType.PERSIST
    )
    @JsonIgnore
    private Product product;

    @Column(
            nullable = false
    )
    private Long quantity;
    @Column(
            nullable = false
    )
    private String operation;

    @Column(
            nullable = false
    )
    private LocalDate date = LocalDate.now();


    public Quantity(Long quantity, String operation) {
        this.quantity = quantity;
        this.operation = operation;

    }
    @PrePersist
    public void prePersist() {
        if (this.date == null) {
            this.date = LocalDate.now();
        }
    }
}
