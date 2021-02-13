package com.codecool.backend.entity;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Project")
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    @NaturalId
    @Column(nullable = false)
    private String title;

    @OneToMany(
            mappedBy = "project",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TeamProjectAssociation> teams = new ArrayList<>();

    private LocalDate created;

    public void addTeam(Team team) {
        TeamProjectAssociation teamProject = new TeamProjectAssociation(team, this);
        teams.add(teamProject);
        team.getProjects().add(teamProject);
    }

    public void removeTeam(Team team) {
        for (Iterator<TeamProjectAssociation> iterator = teams.iterator();
             iterator.hasNext(); ) {
            TeamProjectAssociation teamProject = iterator.next();

            if (teamProject.getProject().equals(this) &&
                    teamProject.getTeam().equals(team)) {
                iterator.remove();
                teamProject.getTeam().getProjects().remove(teamProject);
                teamProject.setProject(null);
                teamProject.setTeam(null);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(title, project.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
