package com.educandoweb.shopline.services;

import com.educandoweb.shopline.entities.Product;
import com.educandoweb.shopline.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> product = this.productRepository.findById(id);
        return product.get();
    }
}
