package com.codecool.backend;

import com.codecool.backend.entity.ApplicationUser;
import com.codecool.backend.entity.Project;
import com.codecool.backend.entity.Team;
import com.codecool.backend.modal.Location;
import com.codecool.backend.repository.ProjectRepository;
import com.codecool.backend.repository.TeamRepository;
import com.codecool.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootApplication
public class BackendApplication {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TeamRepository teamRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {

            //users
            ApplicationUser john = new ApplicationUser();
            john.setName("John");
            john.setLocation(Location.BUDAPEST);
            john.setExperiencePoint(50);

            ApplicationUser jane = new ApplicationUser();
            jane.setName("Jane");
            jane.setLocation(Location.BUDAPEST);
            jane.setExperiencePoint(60);

            ApplicationUser jack = new ApplicationUser();
            jack.setName("Jack");
            jack.setLocation(Location.MISKOLC);
            jack.setExperiencePoint(55);

            ApplicationUser jill = new ApplicationUser();
            jill.setName("Jill");
            jill.setLocation(Location.MISKOLC);
            jill.setExperiencePoint(45);

            //teams
            Team team1 = new Team();
            team1.setName("BestTeam");

            Team team2 = new Team();
            team2.setName("Jack&Jill");

            //projects
            Project p1 = new Project();
            p1.setTitle("You Don't Know JS Yet");
            p1.setCreated(LocalDate.of(2020, 02, 01));

            Project p2 = new Project();
            p2.setTitle("List of Free Learning Resources");
            p2.setCreated(LocalDate.of(2020, 02, 02));

            Project p3 = new Project();
            p3.setTitle("Bootstrap");
            p3.setCreated(LocalDate.of(2020, 02, 03));

            Project p4 = new Project();
            p4.setTitle("Coding Interview University");
            p4.setCreated(LocalDate.of(2020, 02, 04));

            Project p5 = new Project();
            p5.setTitle("Awesome Python");
            p5.setCreated(LocalDate.of(2020, 02, 05));

            team1.getApplicationUsers().add(john);
            team1.getApplicationUsers().add(jane);

            team2.getApplicationUsers().add(jack);
            team2.getApplicationUsers().add(jill);

            p1.getTeams().add(team1);
            p1.getTeams().add(team2);

            projectRepository.save(p1);
            projectRepository.save(p2);
            projectRepository.save(p3);
            projectRepository.save(p4);
            projectRepository.save(p5);
        };
    }
}


