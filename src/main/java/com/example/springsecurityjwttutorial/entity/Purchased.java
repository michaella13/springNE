package com.example.springsecurityjwttutorial.entity;

import com.example.springsecurityjwttutorial.dto.PurchaseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Purchased")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchased {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            cascade = CascadeType.PERSIST
    )
    private Product product;

    @Column(
            nullable = false
    )
    private Long quantity;
    @Column(
            nullable = false
    )
    private Long total;
    @Column(
            nullable = false
    )
    private LocalDate date= LocalDate.now();

//    public Purchased(PurchaseDto purchaseDto) {
//    }

    @PrePersist
    public void prePersist() {
        if (this.date == null) {
            this.date = LocalDate.now();
        }
    }
    public Purchased(Long quantity, Long total) {
        this.quantity = quantity;
        this.total = total;

    }
}
