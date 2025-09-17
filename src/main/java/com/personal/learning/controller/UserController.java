package com.personal.learning.controller;

import com.personal.learning.model.User;
import com.personal.learning.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        logger.debug("GET /api/users called");
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        logger.debug("GET /api/users/{} called", id);
        return ResponseEntity.ok(service.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        logger.debug("POST /api/users called with payload: {}", user);
        return ResponseEntity.status(201).body(service.createUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        logger.debug("DELETE /api/users/{} called ", id);
        service.deleteUser(id);
        return ResponseEntity.noContent().build();

    }
}
