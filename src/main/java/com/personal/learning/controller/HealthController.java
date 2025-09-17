package com.personal.learning.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/api/health")
    public Map<String, String> healthCheck(){
        return Map.of("status", "Up", "message" , " Spring Boot Backend is Running fine");
    }
}
