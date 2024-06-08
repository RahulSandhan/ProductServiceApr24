package com.example.apr24firstapi.controllers;

import com.example.apr24firstapi.components.AuthUtils;
import com.example.apr24firstapi.dtos.CreateProductRequestDto;
import com.example.apr24firstapi.models.Product;
import com.example.apr24firstapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//  URL: localhost:8080
@RequestMapping("products")
public class ProductController {
    private ProductService productService;

    private AuthUtils authUtils;

    @Autowired
    public ProductController(@Qualifier("selfProduct") ProductService productService, AuthUtils authUtils) {
        this.productService = productService;
        this.authUtils = authUtils;
    }

    //GET localhost:8080/products/1
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id){
        return productService.getProductById(id);
    }

    public List<Product> getProducts(){
        return new ArrayList<Product>();
    }

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDto requestDto, @RequestHeader("Auth") String token){
        //validate the data
        if(!authUtils.validateToken(token)){  //if token is not valid, then we are going to return null
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED); // if token is not valid, we will give them Unauthorized(401) or Forbidden(403)
        }


        Product product =  productService.createProduct(requestDto.getTitle(), requestDto.getDescription(),
                requestDto.getImage(), requestDto.getPrice(), requestDto.getCategoryName());
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
}
