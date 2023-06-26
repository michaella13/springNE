package com.example.springsecurityjwttutorial.services;

import com.example.springsecurityjwttutorial.dto.ProductDto;
import com.example.springsecurityjwttutorial.entity.Product;
import com.example.springsecurityjwttutorial.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    public Product registerProduct(ProductDto productDto) {
        Product product =
                new Product(productDto.getProductCode(), productDto.getProductName(),productDto.getProductType(), productDto.getPrice());
        return productRepo.save(product);
    }


    public Product getProductById(Long productId) {
        Optional<Product> productOptional =
                productRepo.findById(productId);
        return productOptional.get();
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product updateProduct(Product updated) {
        return productRepo.save(updated);
    }
}
