package com.example.springsecurityjwttutorial.services;


import com.example.springsecurityjwttutorial.dto.PurchaseDto;
import com.example.springsecurityjwttutorial.dto.QuantityDto;
import com.example.springsecurityjwttutorial.entity.Product;
import com.example.springsecurityjwttutorial.entity.Purchased;

import com.example.springsecurityjwttutorial.entity.Quantity;
import com.example.springsecurityjwttutorial.repository.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
        PurchaseRepo purchaseRepo;
    @Autowired
    ProductService productService;

    public Purchased registerPurchased(PurchaseDto purchaseDto, Long productId) {
        Product product=
                productService.getProductById(productId);
        Purchased purchased =
                new Purchased(purchaseDto.getQuantity(),purchaseDto.getTotal());
        purchased.setProduct(product);

        Purchased savedPurchased = purchaseRepo.save(purchased);
//        product.setQuantity(savedQuantity);
//        productService.updateProduct(product);
        return savedPurchased;

    }
}



