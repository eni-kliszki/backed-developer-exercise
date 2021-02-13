package com.codecool.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @JoinTable(
            name="TEAMS_USERS",
            joinColumns=@JoinColumn(name="TEAM_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"))
    private Set<ApplicationUser> applicationUsers = new HashSet<>();

    @ManyToMany(mappedBy = "teams")
    Set<Project> projects;

//    public void addUser(ApplicationUser applicationUser) {
//        if (!users.contains(applicationUser)) {
//            users.add(applicationUser);
//            applicationUser.addTeam(this);
//        }
//    }
}
