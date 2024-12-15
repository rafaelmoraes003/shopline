package com.educandoweb.shopline.repositories;

import com.educandoweb.shopline.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
