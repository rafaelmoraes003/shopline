package com.educandoweb.shopline.repositories;

import com.educandoweb.shopline.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
