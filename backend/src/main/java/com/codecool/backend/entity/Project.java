package com.codecool.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name="PROJECTS_TEAMS",
            joinColumns=@JoinColumn(name="PROJECT_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="TEAM_ID", referencedColumnName="ID"))
    private Set<Team> teams = new HashSet<>();

    private LocalDate created;

}
