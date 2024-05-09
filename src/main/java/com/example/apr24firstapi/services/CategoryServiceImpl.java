package com.example.apr24firstapi.services;

import com.example.apr24firstapi.models.Category;
import com.example.apr24firstapi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        /*
        If id us null for the object being saved: then insert query will be fired
        Else update query will be fired.
         */
        return categoryRepository.save(category);
    }
}
