package com.codecool.backend.service;

import com.codecool.backend.entity.Project;
import com.codecool.backend.model.TeamProject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProjectService {

    public void createTeamProjects(List<Project> projects, Set<TeamProject> teamProjects) {
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
    };
}
