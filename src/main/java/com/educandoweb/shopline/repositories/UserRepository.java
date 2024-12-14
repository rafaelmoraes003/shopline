package com.educandoweb.shopline.repositories;

import com.educandoweb.shopline.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
