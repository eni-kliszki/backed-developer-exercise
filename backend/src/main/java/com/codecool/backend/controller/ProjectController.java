package com.codecool.backend.controller;

import com.codecool.backend.entity.Project;
import com.codecool.backend.entity.Team;
import com.codecool.backend.modal.TeamProject;
import com.codecool.backend.repository.ProjectRepository;
import com.codecool.backend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/data")
    public ResponseEntity<List<TeamProject>> getAllMedia() {
        List<Project> projects = projectRepository.findAll();
        List<TeamProject> teamProjects = new ArrayList<>();

        projects.stream().forEach(project -> {
            TeamProject teamProject = new TeamProject();

            teamProject.setTitle(project.getTitle());
            teamProject.setUrl(project.getGithubURL());
            teamProject.setCreated(project.getCreated());

            Set<String> teamAvatarUrls = new HashSet<>();
            project.getTeam().getApplicationUsers().stream().forEach(user -> {
                teamAvatarUrls.add(user.getPictureURL());
            });
            teamProject.setTeamAvatarUrls(teamAvatarUrls);

            teamProjects.add(teamProject);
        });

        return ResponseEntity.ok(teamProjects);
    }
}
