package com.codecool.backend;

import com.codecool.backend.entity.ApplicationUser;
import com.codecool.backend.entity.Project;
import com.codecool.backend.entity.Team;
import com.codecool.backend.model.Location;
import com.codecool.backend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.*;


@SpringBootApplication
public class BackendApplication {

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
            ApplicationUser adi = new ApplicationUser();
                adi.setName("Ádi");
                adi.setLocation(Location.BUDAPEST);
                adi.setExperiencePoint(Map.of("JavaScript",100, "Java", 80, "TypeScript", 30));
                adi.setPictureURL("https://cc-journey-student-profile-images.s3.amazonaws.com/1f42627e-a65d-496c-abde-c82c109f410a");

            ApplicationUser fazi = new ApplicationUser();
                fazi.setName("Fazi");
                fazi.setLocation(Location.BUDAPEST);
                fazi.setExperiencePoint(Map.of("JavaScript",90, "Java", 80, "TypeScript", 10));
                fazi.setPictureURL("https://cc-journey-student-profile-images.s3.amazonaws.com/672158fb-626d-4cc5-b8dd-bb20153aadde");

            ApplicationUser krisz = new ApplicationUser();
                krisz.setName("Krisz");
                krisz.setLocation(Location.BUDAPEST);
                krisz.setExperiencePoint(Map.of("JavaScript",70, "Java", 80, "TypeScript", 1));
                krisz.setPictureURL("https://cc-journey-student-profile-images.s3.amazonaws.com/385e9dc7-dc3b-4fe7-9daf-5941a8e09348");

            ApplicationUser marci = new ApplicationUser();
                marci.setName("Marci");
                marci.setLocation(Location.MISKOLC);
                marci.setExperiencePoint(Map.of("JavaScript",90, "Java", 90, "TypeScript", 20));
                marci.setPictureURL("https://storage.googleapis.com/journey-profile-images/fb688946-eccb-47ee-ae54-84a8e0d74d42.png");

            ApplicationUser omar = new ApplicationUser();
                omar.setName("Omar");
                omar.setLocation(Location.MISKOLC);
                omar.setExperiencePoint(Map.of("JavaScript",80, "Java", 80,"Python", 70));
                omar.setPictureURL("https://cc-journey-student-profile-images.s3.amazonaws.com/d6c6e99a-3bbd-4754-b677-bca318dc0905");

            ApplicationUser eszkis = new ApplicationUser();
                eszkis.setName("Eszkis");
                eszkis.setLocation(Location.MISKOLC);
                eszkis.setExperiencePoint(Map.of("JavaScript",60, "Java", 100, "Python", 80));
                eszkis.setPictureURL("https://cc-journey-student-profile-images.s3.amazonaws.com/b9361d47-dc90-44b9-ad1e-4abdf5bd7877");

            ApplicationUser katt = new ApplicationUser();
                katt.setName("Katt");
                katt.setLocation(Location.WARSAW);
                katt.setExperiencePoint(Map.of("JavaScript",70, "Java", 70));
                katt.setPictureURL("https://cc-journey-student-profile-images.s3.amazonaws.com/291fcab0-eadc-497e-b53e-3583e3d7b228");


            ApplicationUser eni = new ApplicationUser();
                eni.setName("Eni");
                eni.setLocation(Location.WARSAW);
                eni.setExperiencePoint(Map.of("JavaScript",80, "Java", 80, "Docker", 10, "TypeScript", 30));
                eni.setPictureURL("https://cc-journey-student-profile-images.s3.amazonaws.com/9ebc62ee-7c59-44fb-9014-7cebe8fae924");


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

            Project p6 = Project.builder()
                    .title("JS power hours")
                    .githubURL("https://github.com/vinta/awesome-python")
                    .created(LocalDate.of(2020, 02, 06))
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

            Team team4 = new Team();
                team4.setName("Ask the JS ninja");
                team4.setProjects(Set.of(p6));

            // set the applicationUsers of the teams
            team1.getApplicationUsers().add(adi);
            team1.getApplicationUsers().add(fazi);

            team2.getApplicationUsers().add(marci);
            team2.getApplicationUsers().add(eszkis);
            team2.getApplicationUsers().add(omar);

            team3.getApplicationUsers().add(katt);
            team3.getApplicationUsers().add(eni);

            team4.getApplicationUsers().add(adi);
            team4.getApplicationUsers().add(fazi);
            team4.getApplicationUsers().add(krisz);

            // set the teams of the projects
            p1.setTeam(team1);
            p2.setTeam(team1);
            p3.setTeam(team2);
            p4.setTeam(team3);
            p5.setTeam(team3);
            p6.setTeam(team4);

            // set the teams of the users
            adi.getTeams().add(team1);
            fazi.getTeams().add(team1);

            marci.getTeams().add(team2);
            eszkis.getTeams().add(team2);
            omar.getTeams().add(team2);

            katt.getTeams().add(team3);
            eni.getTeams().add(team3);

            adi.getTeams().add(team4);
            fazi.getTeams().add(team4);
            krisz.getTeams().add(team4);

            teamRepository.save(team1);
            teamRepository.save(team2);
            teamRepository.save(team3);
            teamRepository.save(team4);
        };
    }
}


