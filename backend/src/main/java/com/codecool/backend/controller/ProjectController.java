package com.codecool.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ProjectController {

    @GetMapping("/")
    public ResponseEntity<String> getAllMedia() {
        
        return ResponseEntity.ok("OK");
    }
}
