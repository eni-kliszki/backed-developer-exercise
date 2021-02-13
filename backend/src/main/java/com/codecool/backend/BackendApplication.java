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
            ApplicationUser john = new ApplicationUser();
            john.setName("John");
            john.setLocation(Location.BUDAPEST);
            john.setExperiencePoint(50);

            ApplicationUser jane = new ApplicationUser();
            jane.setName("Jane");
            jane.setLocation(Location.MISKOLC);
            jane.setExperiencePoint(60);

            Team team1 = new Team();
            team1.setName("BestTeam");

            team1.getApplicationUsers().add(john);
            team1.getApplicationUsers().add(jane);

            teamRepository.save(team1);
        };
    }
}
//
//            Project p1 = Project.builder()
//                    .title("You Don't Know JS Yet")
//                    .created(LocalDate.of(2020, 02, 01))
//                    .team(team1)
//                    .build();
//
//            Project p2 = Project.builder()
//                    .title("List of Free Learning Resources")
//                    .created(LocalDate.of(2020, 02, 02))
//                    .build();
//
//            Project p3 = Project.builder()
//                    .title("Bootstrap")
//                    .created(LocalDate.of(2020, 02, 03))
//                    .build();
//
//            Project p4 = Project.builder()
//                    .title("Coding Interview University")
//                    .created(LocalDate.of(2020, 02, 04))
//                    .build();
//
//            Project p5 = Project.builder()
//                    .title("Awesome Python")
//                    .created(LocalDate.of(2020, 02, 05))
//                    .build();

