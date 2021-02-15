package com.codecool.backend.service;

import com.codecool.backend.entity.Team;
import com.codecool.backend.model.TeamModel;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class TeamService {

    public void transformTeamToTeamModel(List<Team> teams, List<TeamModel> teamModels){
        teams.stream().forEach(team -> {
            TeamModel teamModel = new TeamModel();
            teamModel.setName(team.getName());
            teamModel.setAverageExperiencePoint(team.getAverageExperiencePoint());

            team.getApplicationUsers().stream().forEach(user -> {
                teamModel.getUsersUrl().add(user.getPictureURL());
            });
            teamModels.add(teamModel);
        });
    }

    public List<Team> find3MostExperiencedTeams(List<Team> teams) {
        setTeamsAverageExperiencePoint(teams);
        Collections.sort(teams, Collections.reverseOrder());
        return teams.subList(0, 3);
    }

    private void setTeamsAverageExperiencePoint(List<Team> teams){
        teams.stream().forEach(team -> {
            int point = countExperiencePoints(team);
            team.setAverageExperiencePoint(Math.round(point / team.getApplicationUsers().size()));
        });
    }

    private int countExperiencePoints(Team team){
        return team.getApplicationUsers().stream().flatMap(user ->
                user.getExperiencePoint().entrySet().stream()).mapToInt(Map.Entry::getValue).sum();
    }
}
