package com.codecool.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamProject {
    private String title;
    private String url;
    private Set<String> teamAvatarUrls = new HashSet<>();
    private LocalDate created;
    List<Map<String, Integer>> usersExperiencePoints = new ArrayList<>();
}
