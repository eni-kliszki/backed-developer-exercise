package com.codecool.backend.entity;

import com.codecool.backend.modal.Location;
import lombok.*;

import javax.persistence.*;
import java.util.*;

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

    @Transient
    private Map<String, Integer> chanceToLearn = new HashMap<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationUser that = (ApplicationUser) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                location == that.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location);
    }
}
