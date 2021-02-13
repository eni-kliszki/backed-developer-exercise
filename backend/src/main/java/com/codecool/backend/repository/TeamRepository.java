package com.codecool.backend.repository;

import com.codecool.backend.entity.Project;
import com.codecool.backend.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
