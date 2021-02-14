package com.codecool.backend.entity;

import com.codecool.backend.modal.Location;
import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Location location;

    @ElementCollection
    @MapKeyColumn(name="technology")
    @Column(name="points")
    @CollectionTable(name="experience_point")
    private Map<String, Integer> experiencePoint = new HashMap<>();

    private String pictureURL;

    @ManyToMany(mappedBy="applicationUsers", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Team> teams = new HashSet<>();
}
