package com.example.apr24firstapi.controllers;

import com.example.apr24firstapi.dtos.CreateProductRequestDto;
import com.example.apr24firstapi.models.Product;
import com.example.apr24firstapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//  URL: localhost:8080
@RequestMapping("products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("selfProduct") ProductService productService) {
        this.productService = productService;
    }

    //GET localhost:8080/products/1
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id){
        return productService.getProductById(id);
    }

    public List<Product> getProducts(){
        return new ArrayList<Product>();
    }

    @PostMapping("")
    public Product createProduct(@RequestBody CreateProductRequestDto requestDto){
        //validate the data

        return productService.createProduct(requestDto.getTitle(), requestDto.getDescription(),
                requestDto.getImage(), requestDto.getPrice(), requestDto.getCategoryName());
    }
}
