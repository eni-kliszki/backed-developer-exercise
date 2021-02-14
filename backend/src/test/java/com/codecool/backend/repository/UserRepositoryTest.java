package com.codecool.backend.repository;

import com.codecool.backend.entity.ApplicationUser;
import com.codecool.backend.modal.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    private ApplicationUser adi;
    private ApplicationUser marci;

    @BeforeEach
    private void init(){

        ApplicationUser adi = new ApplicationUser();
        adi.setName("Ádi");
        adi.setLocation(Location.BUDAPEST);
        adi.setExperiencePoint(Map.of("JavaScript",100, "Java", 80, "Docker", 1, "TypeScript", 30));
        adi.setPictureURL("https://cc-journey-student-profile-images.s3.amazonaws.com/1f42627e-a65d-496c-abde-c82c109f410a");

        ApplicationUser marci = new ApplicationUser();
        marci.setName("Marci");
        marci.setLocation(Location.MISKOLC);
        marci.setExperiencePoint(Map.of("JavaScript",90, "Java", 90, "Docker", 1, "TypeScript", 20));
        marci.setPictureURL("https://storage.googleapis.com/journey-profile-images/fb688946-eccb-47ee-ae54-84a8e0d74d42.png");

        repository.saveAll(Arrays.asList(adi, marci));
    }

    @Test
    public void testFindUserByLocation(){
        List<ApplicationUser> users = repository.findAllByLocation(Location.MISKOLC);
        assertEquals(marci, users.get(0));
    }
}