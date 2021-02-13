package com.codecool.backend.entity;

import com.codecool.backend.modal.Location;
import lombok.*;

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
    private String pictureURL;

    @ManyToMany(mappedBy="applicationUsers")
    private Set<Team> teams = new HashSet<>();
}
