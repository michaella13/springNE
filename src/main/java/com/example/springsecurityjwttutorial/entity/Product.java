package com.example.springsecurityjwttutorial.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(
            nullable = false
    )
    private String productCode;
    @Column(
            nullable = false
    )
    private String productName;
    @Column(
            nullable = false
    )
    private String productType;

    @Column(
            nullable = false
    )
    private Long price;

    @Column(
            nullable = false
    )
    private LocalDate inDate= LocalDate.now();


    @OneToOne
    private Quantity quantity;


    public Product(String productCode, String productName, String productType, Long price) {
        this.productCode = productCode;
        this.productName = productName;
        this.productType = productType;
        this.price = price;


    }
    @PrePersist
    public void prePersist() {
        if (this.inDate == null) {
            this.inDate = LocalDate.now();
        }
    }
}
