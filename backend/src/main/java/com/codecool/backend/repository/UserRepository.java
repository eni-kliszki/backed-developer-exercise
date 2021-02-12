package com.codecool.backend.repository;

import com.codecool.backend.entity.ApplicationUser;
import com.codecool.backend.modal.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<ApplicationUser, Long> {
    List<ApplicationUser> findAllByLocation(Location location);
}
