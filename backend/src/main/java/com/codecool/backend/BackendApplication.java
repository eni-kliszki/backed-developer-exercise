package com.codecool.backend;

import com.codecool.backend.entity.ApplicationUser;
import com.codecool.backend.entity.Project;
import com.codecool.backend.modal.Location;
import com.codecool.backend.repository.ProjectRepository;
import com.codecool.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;


@SpringBootApplication
public class BackendApplication {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectRepository projectRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            ApplicationUser john = ApplicationUser.builder()
                    .name("John")
                    .location(Location.BUDAPEST)
                    .experiencePoint(50)
                    .build();

            ApplicationUser jane = ApplicationUser.builder()
                    .name("Jane")
                    .location(Location.MISKOLC)
                    .experiencePoint(60)
                    .build();

            Project p1 = Project.builder()
                    .title("You Don't Know JS Yet")
                    .created(LocalDate.of(2020, 02, 01))
                    .build();

            Project p2 = Project.builder()
                    .title("List of Free Learning Resources")
                    .created(LocalDate.of(2020, 02, 02))
                    .build();

            Project p3 = Project.builder()
                    .title("Bootstrap")
                    .created(LocalDate.of(2020, 02, 03))
                    .build();

            Project p4 = Project.builder()
                    .title("Coding Interview University")
                    .created(LocalDate.of(2020, 02, 04))
                    .build();

            Project p5 = Project.builder()
                    .title("Awesome Python")
                    .created(LocalDate.of(2020, 02, 05))
                    .build();

            userRepository.saveAll(Arrays.asList(john, jane));
            projectRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        };
    }
}
