package com.codecool.backend.controller;

import com.codecool.backend.entity.ApplicationUser;
import com.codecool.backend.entity.Project;
import com.codecool.backend.modal.TeamProject;
import com.codecool.backend.repository.ProjectRepository;
import com.codecool.backend.repository.UserRepository;
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
    private UserRepository userRepository;

    @GetMapping("/data")
    public ResponseEntity<List<TeamProject>> getAllMedia() {
        List<Project> projects = projectRepository.findAll();
        List<TeamProject> teamProjects = new ArrayList<>();

        projects.stream().forEach(project -> {
            TeamProject teamProject = new TeamProject();

            teamProject.setTitle(project.getTitle());
            teamProject.setUrl(project.getGithubURL());
            teamProject.setCreated(project.getCreated());

            project.getTeam().getApplicationUsers().stream().forEach(user -> {
                teamProject.getTeamAvatarUrls().add(user.getPictureURL());
                teamProject.getUsersExperiencePoints().add(user.getExperiencePoint());
            });

            teamProjects.add(teamProject);
        });
        findMates();
        return ResponseEntity.ok(teamProjects);
    }

    private Map<ApplicationUser, Set<ApplicationUser>> findMates() {
        List<ApplicationUser> users = userRepository.findAll();
        Map<ApplicationUser, Set<ApplicationUser>> userMates = new HashMap<>();

        users.stream().forEach(user -> {
            Set<ApplicationUser> mates = new HashSet<>();
            user.getTeams().stream().forEach(team -> {
                team.getApplicationUsers().stream().forEach(mate -> {
                    if (!user.equals(mate)) {
                        mates.add(mate);
                    }
                });
            });
            userMates.put(user, mates);
        });
        System.out.println(userMates);
        return userMates;
    }

}
