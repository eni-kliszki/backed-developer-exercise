package com.codecool.backend.controller;

import com.codecool.backend.entity.ApplicationUser;
import com.codecool.backend.entity.Team;
import com.codecool.backend.model.TeamWithUsers;
import com.codecool.backend.repository.TeamRepository;
import com.codecool.backend.repository.UserRepository;
import com.codecool.backend.service.ChanceToLearn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;


    @GetMapping("/fame")
    public ResponseEntity<List<TeamWithUsers>> getTheBest() {
        List<Team> teams = find3MostExperiencedTeams();

        List<TeamWithUsers> modalTeams = new ArrayList<>();

        teams.stream().forEach(team -> {
            TeamWithUsers teamWithUsers = new TeamWithUsers();
            teamWithUsers.setName(team.getName());
            teamWithUsers.setAverageExperiencePoint(team.getAverageExperiencePoint());

            team.getApplicationUsers().stream().forEach(user -> {
                teamWithUsers.getUsersUrl().add(user.getPictureURL());
            });
            modalTeams.add(teamWithUsers);
        });
        return ResponseEntity.ok(modalTeams);
    }



    private List<Team> find3MostExperiencedTeams() {
        setTeamsAverageExperiencePoint();
        List<Team> teams = teamRepository.findAll();
        Collections.sort(teams, Collections.reverseOrder());
        return teams.subList(0, 3);
    }

    private void setTeamsAverageExperiencePoint(){
        List<Team> teams = teamRepository.findAll();
        teams.stream().forEach(team -> {
            int point = countExperiencePoints(team);
            team.setAverageExperiencePoint((int) Math.round(point / team.getApplicationUsers().size()));
        });
    }

    private int countExperiencePoints(Team team){
        return team.getApplicationUsers().stream().flatMap(user ->
                user.getExperiencePoint().entrySet().stream()).mapToInt(Map.Entry::getValue).sum();
    }
}
