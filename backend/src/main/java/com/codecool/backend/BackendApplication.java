package com.codecool.backend;

import com.codecool.backend.entity.ApplicationUser;
import com.codecool.backend.modal.Location;
import com.codecool.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;


@SpringBootApplication
public class BackendApplication {

    @Autowired
    UserRepository userRepository;

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

            userRepository.saveAll(Arrays.asList(john, jane));
        };
    }
}
