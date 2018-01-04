package com.jeonguk.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeonguk.web.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}