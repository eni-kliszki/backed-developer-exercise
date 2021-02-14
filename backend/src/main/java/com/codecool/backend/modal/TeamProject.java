package com.codecool.backend.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class TeamProject {
    private String title;
    private String url;
    private Set<String> teamAvatarUrls = new HashSet<>();
    private LocalDate created;
    List<Map<String, Integer>> usersExperiencePoints = new ArrayList<>();
}
