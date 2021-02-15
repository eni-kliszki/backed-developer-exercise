package com.codecool.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamModel {
    private String name;
    private Set<String> usersUrl = new HashSet<>();
    private Integer averageExperiencePoint;

}
