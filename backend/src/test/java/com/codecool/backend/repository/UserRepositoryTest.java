package com.codecool.backend.repository;

import com.codecool.backend.entity.ApplicationUser;
import com.codecool.backend.modal.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    private ApplicationUser john;
    private ApplicationUser jane;

    @BeforeEach
    private void init(){
        john = ApplicationUser.builder()
                .name("John")
                .location(Location.BUDAPEST)
                .experiencePoint(50)
                .build();

        jane = ApplicationUser.builder()
                .name("Jane")
                .location(Location.MISKOLC)
                .experiencePoint(60)
                .build();

        repository.saveAll(Arrays.asList(john, jane));
    }

    @Test
    public void testFindUserByLocation(){
        List<ApplicationUser> users = repository.findAllByLocation(Location.MISKOLC);
        assertEquals(jane, users.get(0));
    }
}