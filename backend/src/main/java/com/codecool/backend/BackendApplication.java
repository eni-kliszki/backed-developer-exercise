package com.codecool.backend;

import com.codecool.backend.entity.ApplicationUser;
import com.codecool.backend.entity.Project;
import com.codecool.backend.entity.Team;
import com.codecool.backend.modal.Location;
import com.codecool.backend.repository.ProjectRepository;
import com.codecool.backend.repository.TeamRepository;
import com.codecool.backend.repository.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.*;


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
            ApplicationUser adi = ApplicationUser.builder()
                    .name("Ádi")
                    .location(Location.BUDAPEST)
                    .experiencePoint(60)
                    .pictureURL("https://cc-journey-student-profile-images.s3.amazonaws.com/1f42627e-a65d-496c-abde-c82c109f410a")
                    .build();

            ApplicationUser fazi = ApplicationUser.builder()
                    .name("Fazi")
                    .experiencePoint(55)
                    .location(Location.BUDAPEST)
                    .pictureURL("https://cc-journey-student-profile-images.s3.amazonaws.com/672158fb-626d-4cc5-b8dd-bb20153aadde")
                    .build();

            ApplicationUser marci = ApplicationUser.builder()
                    .name("Marci")
                    .experiencePoint(55)
                    .location(Location.MISKOLC)
                    .pictureURL("https://storage.googleapis.com/journey-profile-images/fb688946-eccb-47ee-ae54-84a8e0d74d42.png")
                    .build();

            ApplicationUser omar = ApplicationUser.builder()
                    .name("Omar")
                    .experiencePoint(50)
                    .location(Location.MISKOLC)
                    .pictureURL("https://cc-journey-student-profile-images.s3.amazonaws.com/d6c6e99a-3bbd-4754-b677-bca318dc0905")
                    .build();

            ApplicationUser eszkis = ApplicationUser.builder()
                    .name("Eszkis")
                    .experiencePoint(50)
                    .location(Location.MISKOLC)
                    .pictureURL("https://cc-journey-student-profile-images.s3.amazonaws.com/b9361d47-dc90-44b9-ad1e-4abdf5bd7877")
                    .build();

            ApplicationUser katt = ApplicationUser.builder()
                    .name("Katt")
                    .experiencePoint(50)
                    .location(Location.WARSAW)
                    .pictureURL("https://cc-journey-student-profile-images.s3.amazonaws.com/291fcab0-eadc-497e-b53e-3583e3d7b228")
                    .build();

            ApplicationUser eni = ApplicationUser.builder()
                    .name("Eni")
                    .experiencePoint(50)
                    .location(Location.WARSAW)
                    .pictureURL("https://cc-journey-student-profile-images.s3.amazonaws.com/9ebc62ee-7c59-44fb-9014-7cebe8fae924")
                    .build();

            //projects
            Project p1 = Project.builder()
                    .title("You Don't Know JS Yet")
                    .githubURL("https://github.com/getify/You-Dont-Know-JS")
                    .created(LocalDate.of(2020, 02, 01))
                    .build();

            Project p2 = Project.builder()
                    .title("List of Free Learning Resources")
                    .githubURL("https://github.com/EbookFoundation/free-programming-books")
                    .created(LocalDate.of(2020, 02, 02))
                    .build();

            Project p3 = Project.builder()
                    .title("Bootstrap")
                    .githubURL("https://github.com/twbs/bootstrap")
                    .created(LocalDate.of(2020, 02, 03))
                    .build();

            Project p4 = Project.builder()
                    .title("Coding Interview University")
                    .githubURL("https://github.com/jwasham/coding-interview-university")
                    .created(LocalDate.of(2020, 02, 04))
                    .build();

            Project p5 = Project.builder()
                    .title("Awesome Python")
                    .githubURL("https://github.com/vinta/awesome-python")
                    .created(LocalDate.of(2020, 02, 05))
                    .build();

            //teams
            Team team1 = new Team();
            team1.setName("BestTeam");
            team1.setProjects(Set.of(p1, p2));

            Team team2 = new Team();
            team2.setName("Msc");
            team2.setProjects(Set.of(p3));

            Team team3 = new Team();
            team3.setName("Warsi");
            team3.setProjects(Set.of(p4, p5));

            team1.getApplicationUsers().add(adi);
            team1.getApplicationUsers().add(fazi);

            team2.getApplicationUsers().add(marci);
            team2.getApplicationUsers().add(eszkis);
            team2.getApplicationUsers().add(omar);

            team3.getApplicationUsers().add(katt);
            team3.getApplicationUsers().add(eni);

            p1.setTeam(team1);
            p2.setTeam(team1);
            p3.setTeam(team2);
            p4.setTeam(team3);
            p5.setTeam(team3);

            teamRepository.save(team1);
            teamRepository.save(team2);
            teamRepository.save(team3);

        };
    }
}


