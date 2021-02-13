package com.codecool.backend.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class TeamProject {
    private String title;
    private String url;
    private Set<String> teamAvatarUrls = new HashSet<>();
    private LocalDate created;
}
