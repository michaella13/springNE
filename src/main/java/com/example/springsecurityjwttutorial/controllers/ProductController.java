package com.example.springsecurityjwttutorial.controllers;


import com.example.springsecurityjwttutorial.dto.ProductDto;
import com.example.springsecurityjwttutorial.entity.Product;
import com.example.springsecurityjwttutorial.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping
    public List <Product> getProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product registerProduct(
            @RequestBody ProductDto productDto
    ) {
        return productService.registerProduct(productDto);
    }


}
