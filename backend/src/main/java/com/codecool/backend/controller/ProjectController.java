package com.codecool.backend.controller;

import com.codecool.backend.entity.Team;
import com.codecool.backend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ProjectController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/data")
    public ResponseEntity<String> getAllMedia() {
        List<Team> teams = teamRepository.findAll();
        return ResponseEntity.ok("OK");
    }
}
