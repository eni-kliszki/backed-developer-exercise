package com.codecool.backend.service;

import com.codecool.backend.entity.ApplicationUser;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChanceToLearn {

    private Map<ApplicationUser, Set<ApplicationUser>> findMates(List<ApplicationUser> users) {
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
        return userMates;
    }

    private void fillChanceToLearnByUsers(List<ApplicationUser> users) {
        Map<ApplicationUser, Set<ApplicationUser>> userMates = findMates(users);
        for (Map.Entry<ApplicationUser, Set<ApplicationUser>> userMatesEntry : userMates.entrySet()) {
            ApplicationUser user = userMatesEntry.getKey();
            userMatesEntry.getValue().stream().forEach(mate -> {
                for (Map.Entry<String, Integer> experience : mate.getExperiencePoint().entrySet()) {
                    String technology = experience.getKey();
                    int mateExperiencePoint = experience.getValue();
                    if(user.getExperiencePoint().containsKey(technology)){
                        if(mateExperiencePoint > user.getExperiencePoint().get(technology)){
                            int diff = mateExperiencePoint - user.getExperiencePoint().get(technology);
                            if(!user.getChanceToLearn().containsKey(technology)){
                                user.getChanceToLearn().put(technology, diff);
                            }else{
                                user.getChanceToLearn().put(technology, user.getChanceToLearn().get(technology) + diff);
                            }
                        }
                    }else{
                        if(!user.getChanceToLearn().containsKey(experience.getKey())){
                            user.getChanceToLearn().put(technology, mateExperiencePoint);
                        }else{
                            user.getChanceToLearn().put(technology, user.getChanceToLearn().get(technology) + mateExperiencePoint);
                        }
                    }

                }
            });
        }
    }

    public ApplicationUser findUserHasBiggestChanceToLearnMost(List<ApplicationUser> users) {
        fillChanceToLearnByUsers(users);
        ApplicationUser userHasBiggestChance = null;
        int biggestTechnologies = 0;
        int biggestPoints = 0;
        for (ApplicationUser user : users) {
            int technologies = user.getChanceToLearn().size();
            if(technologies > biggestTechnologies) {
                int points = 0;
                for (Map.Entry<String, Integer> chance : user.getChanceToLearn().entrySet()) {
                    points += chance.getValue();
                    technologies++;
                }
                if (points > biggestPoints) {
                    userHasBiggestChance = user;
                }
            }
        };
        return userHasBiggestChance;
    }
}
