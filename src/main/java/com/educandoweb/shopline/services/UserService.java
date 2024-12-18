package com.educandoweb.shopline.services;

import com.educandoweb.shopline.entities.User;
import com.educandoweb.shopline.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.get();
    }

    public User insert(User user) {
        return this.userRepository.save(user);
    }

    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }

    public User update(Long id, User userData) {
        User user = this.userRepository.getReferenceById(id);

        user.setName(userData.getName());
        user.setEmail(userData.getEmail());
        user.setPhone(userData.getPhone());

        return this.userRepository.save(user);
    }
}
