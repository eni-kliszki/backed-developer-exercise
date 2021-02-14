package com.codecool.backend.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
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
