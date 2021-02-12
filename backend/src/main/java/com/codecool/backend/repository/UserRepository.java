package com.codecool.backend.repository;

import com.codecool.backend.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<ApplicationUser, Long> {
}
