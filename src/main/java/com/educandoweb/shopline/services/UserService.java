package com.educandoweb.shopline.services;

import com.educandoweb.shopline.entities.User;
import com.educandoweb.shopline.repositories.UserRepository;
import com.educandoweb.shopline.services.exceptions.DatabaseException;
import com.educandoweb.shopline.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public User findById(Long id) throws ResourceNotFoundException {
        Optional<User> user = this.userRepository.findById(id);

        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return this.userRepository.save(user);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        if (!this.userRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        try {
            this.userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }

    }

    public User update(Long id, User userData) {
        User user = this.userRepository.getReferenceById(id);

        user.setName(userData.getName());
        user.setEmail(userData.getEmail());
        user.setPhone(userData.getPhone());

        return this.userRepository.save(user);
    }
}
