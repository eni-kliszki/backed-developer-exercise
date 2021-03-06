package com.codecool.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Team implements Comparable<Team> {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(targetEntity = ApplicationUser.class, cascade = {CascadeType.ALL})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(
            name="TEAMS_USERS",
            joinColumns=@JoinColumn(name="TEAM_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"))
    private Set<ApplicationUser> applicationUsers = new HashSet<>();

    @OneToMany(mappedBy="team", cascade = CascadeType.PERSIST)
    @EqualsAndHashCode.Exclude
    @Singular
    @ToString.Exclude
    private Set<Project> projects;

    @Transient
    private Integer averageExperiencePoint;

    @Override
    public int compareTo(Team team) {
        return this.getAverageExperiencePoint().compareTo(team.getAverageExperiencePoint());
    }
}
