package com.codecool.backend.entity;

import com.codecool.backend.modal.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Location location;

    private int experiencePoint;

    @ManyToMany(mappedBy="applicationUsers")
    private Set<Team> teams = new HashSet<>();
}
