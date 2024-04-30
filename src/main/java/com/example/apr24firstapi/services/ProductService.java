package com.example.apr24firstapi.services;

import com.example.apr24firstapi.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(long id);

    public List<Product> getAllProducts();
}
