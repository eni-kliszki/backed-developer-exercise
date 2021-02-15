package com.codecool.backend.controller;

import com.codecool.backend.entity.Team;
import com.codecool.backend.model.TeamModel;
import com.codecool.backend.repository.TeamRepository;
import com.codecool.backend.service.TeamService;
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

    @Autowired
    private TeamService teamService;

    @GetMapping("/fame")
    public ResponseEntity<List<TeamModel>> getTheBest() {
        List<Team> teams = teamRepository.findAll();

        List<Team> mostExperiencedTeams = teamService.find3MostExperiencedTeams(teams);
        List<TeamModel> teamModels = new ArrayList<>();

        teamService.transformTeamToTeamModel(mostExperiencedTeams, teamModels);

        return ResponseEntity.ok(teamModels);
    }

}
