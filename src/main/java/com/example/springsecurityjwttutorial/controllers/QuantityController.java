package com.example.springsecurityjwttutorial.controllers;

import com.example.springsecurityjwttutorial.dto.QuantityDto;
import com.example.springsecurityjwttutorial.entity.Quantity;
import com.example.springsecurityjwttutorial.services.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quantities")
public class QuantityController {
    @Autowired
    QuantityService quantityService;

    @PostMapping("/{productId}")
    public Quantity registerQuantity(
            @RequestBody QuantityDto quantityDto,
            @PathVariable("productId") Long productId
    ){
        return quantityService.registerQuantity(quantityDto, productId);
    }
}
