package com.codecool.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
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

}
