package com.example.springsecurityjwttutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String productCode;
    private String productName;
    private String productType;
    private Long price;

}
