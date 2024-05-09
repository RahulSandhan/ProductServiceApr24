package com.example.apr24firstapi;

import com.example.apr24firstapi.models.Category;
import com.example.apr24firstapi.models.Product;
import com.example.apr24firstapi.projections.ProductInfo;
import com.example.apr24firstapi.projections.ProductInfo1;
import com.example.apr24firstapi.repositories.CategoryRepository;
import com.example.apr24firstapi.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Apr24FirstApiApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void  testProduct(){
        Optional<ProductInfo> optionalProduct = this.productRepository.getByIdCustomHQL(1L);
        ProductInfo product = optionalProduct.get();
        System.out.println(product.getTitle());
        System.out.println(product.getDescription());
        System.out.println(product.getId());
    }

    @Test
    public void testFetchTypes(){
//        Optional<Category> optionalCategory = this.categoryRepository.findById(1L);
//        Category category = optionalCategory.get();
//        System.out.println(category.getName());
//        List<Product> products = category.getProducts();
//        Product product = products.get(0);

       // Product product = this.productRepository.findById(1L).get();
        // Category category = product.getCategory();
    }
}
