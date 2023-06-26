package com.example.springsecurityjwttutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuantityDto {
    private Long quantity;
    private String operation;
    private String date;
}
