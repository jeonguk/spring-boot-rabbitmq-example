package com.jeonguk.web.service;

import java.util.List;

import com.jeonguk.web.entity.Product;
import com.jeonguk.web.form.ProductForm;

public interface ProductService {

    List<Product> listAll();
    Product getById(Long id);
    Product saveOrUpdate(Product product);
    void delete(Long id);
    Product saveOrUpdateProductForm(ProductForm productForm);
    void sendProductMessage(String id);

}