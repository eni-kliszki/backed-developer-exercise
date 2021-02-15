package com.codecool.backend.controller;

import com.codecool.backend.entity.ApplicationUser;
import com.codecool.backend.repository.UserRepository;
import com.codecool.backend.service.ChanceToLearn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ApplicationUserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChanceToLearn chanceToLearn;

    @GetMapping("/user")
    public ResponseEntity<ApplicationUser> getTheBest() {
        List<ApplicationUser> users = userRepository.findAll();

        return ResponseEntity.ok(chanceToLearn.findUserHasBiggestChanceToLearnMost(users));
    }
}
