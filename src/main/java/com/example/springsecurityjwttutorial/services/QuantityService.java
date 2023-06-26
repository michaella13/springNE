package com.example.springsecurityjwttutorial.services;

import com.example.springsecurityjwttutorial.dto.QuantityDto;
import com.example.springsecurityjwttutorial.entity.Product;
import com.example.springsecurityjwttutorial.entity.Quantity;
import com.example.springsecurityjwttutorial.repository.QuantityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class QuantityService {

    @Autowired
    QuantityRepo quantityRepo;

    @Autowired
    ProductService productService;
    public Quantity registerQuantity(QuantityDto quantityDto, Long productId) {
        Product product =
                productService.getProductById(productId);
        Quantity quantity =
                new Quantity(quantityDto.getQuantity(), quantityDto.getOperation());
        quantity.setProduct(product);

        Quantity savedQuantity =
                quantityRepo.save(quantity);
        product.setQuantity(savedQuantity);
        productService.updateProduct(product);
        return savedQuantity;

    }
}