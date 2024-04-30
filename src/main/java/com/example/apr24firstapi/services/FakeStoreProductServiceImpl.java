package com.example.apr24firstapi.services;

import com.example.apr24firstapi.dtos.FakeProductServiceDto;
import com.example.apr24firstapi.models.Category;
import com.example.apr24firstapi.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService {
    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertDtoToProduct(FakeProductServiceDto dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());
        product.setDescription(dto.getDescription());
        Category category = new Category();
        category.setName(dto.getCategory());
        product.setCategory(category);
        return product;
    }
    @Override
    public Product getProductById(long id) {
        FakeProductServiceDto product = this.restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeProductServiceDto.class);
        return convertDtoToProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}