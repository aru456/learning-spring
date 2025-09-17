package com.personal.learning.service;

import com.personal.learning.exception.ResourceNotFoundException;
import com.personal.learning.model.User;
import com.personal.learning.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAllUsers() {
        logger.info("Fetching all users from database");
        return repo.findAll();
    }

    public User getUserById(Long id) {
        logger.info("Fetching user with id: {}", id);
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    public User createUser(User user) {
        logger.info("Creating new user with name: {}", user.getName());
        return repo.save(user);
    }

    public void deleteUser(Long id) {
        logger.info("Deleting a user with id: {}" , id);
        User user = repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not found with id " + id));
        repo.delete(user);
    }
}
