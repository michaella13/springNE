package com.example.springsecurityjwttutorial.repository;

import com.example.springsecurityjwttutorial.entity.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityRepo extends JpaRepository<Quantity, Long> {
}
