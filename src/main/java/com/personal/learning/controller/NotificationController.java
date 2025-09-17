package com.personal.learning.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*")
public class NotificationController {

    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(@RequestParam String email,
                                            @RequestParam String message) {
        logger.info("Request to send email to {} with message: {}", email, message);
        // Here you’d call an external NotificationService microservice
        return ResponseEntity.ok("Email request sent to " + email);
    }
}
