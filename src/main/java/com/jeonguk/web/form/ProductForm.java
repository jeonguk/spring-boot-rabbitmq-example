package com.jeonguk.web.form;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductForm {
    
    private Long id;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    
}