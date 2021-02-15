package com.codecool.backend.controller;

import com.codecool.backend.entity.Project;
import com.codecool.backend.service.ChanceToLearn;
import com.codecool.backend.service.ProjectService;
import com.codecool.backend.model.TeamProject;
import com.codecool.backend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/data")
    public ResponseEntity<Set<TeamProject>> getAll() {
        List<Project> projects = projectRepository.findAll();
        Set<TeamProject> teamProjects = new HashSet<>();

        projectService.createTeamProjects(projects, teamProjects);
        return ResponseEntity.ok(teamProjects);
    }

}