package com.educandoweb.shopline.services;

import com.educandoweb.shopline.entities.Category;
import com.educandoweb.shopline.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> category = this.categoryRepository.findById(id);
        return category.get();
    }
}
