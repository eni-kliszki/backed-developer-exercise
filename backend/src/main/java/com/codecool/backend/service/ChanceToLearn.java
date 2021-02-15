package com.codecool.backend.service;

import com.codecool.backend.entity.ApplicationUser;
import com.codecool.backend.model.UserModel;
import com.codecool.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChanceToLearn {

    @Autowired
    private UserRepository userRepository;

    public void fillUsersChanceToLearnFromMates(List<ApplicationUser> users) {
        users.stream().forEach(user -> {
            user.getTeams().stream().forEach(team -> {
                team.getApplicationUsers().stream().forEach(mate -> {
                    Set<ApplicationUser> userMates = new HashSet<>();

                    if (!user.equals(mate)) {
                        if(userMates.add(mate)){
                            fillUserChanceToLearnFromMates(mate, user);
                        }
                    }
                });
            });
        });
    }

    private void fillUserChanceToLearnFromMates(ApplicationUser mate, ApplicationUser user) {
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
    }

    public ApplicationUser findUserHasBiggestChanceToLearnMost(List<ApplicationUser> users) {
        ApplicationUser userHasBiggestChance = null;
        int biggestTechnologies = 0;
        int biggestPoints = 0;
        for (ApplicationUser applicationUser : users) {
            int technologies = applicationUser.getChanceToLearn().size();
            if(technologies > biggestTechnologies) {
                int points = 0;
                for (Map.Entry<String, Integer> chance : applicationUser.getChanceToLearn().entrySet()) {
                    points += chance.getValue();
                    technologies++;
                }
                if (points > biggestPoints) {
                    userHasBiggestChance = applicationUser;
                }
            }
        }
        return userHasBiggestChance;
    }
}
