package com.example.springsecurityjwttutorial.repository;

import com.example.springsecurityjwttutorial.entity.Purchased;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepo extends JpaRepository<Purchased, Long> {
}
