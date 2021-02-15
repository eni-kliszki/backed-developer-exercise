package com.codecool.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class TeamWithUsers {
    private String name;
    private Set<String> usersUrl = new HashSet<>();
    private Integer averageExperiencePoint;

}
