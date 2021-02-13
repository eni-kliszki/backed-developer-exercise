package com.codecool.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity(name = "PostTag")
@Table(name = "post_tag")
public class TeamProjectAssociation {

    @EmbeddedId
    private TeamProjectId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("teamId")
    private Team team;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("projectId")
    private Project project;

    @Column(name = "github_url")
    private String githubURL;

    public TeamProjectAssociation(Team team, Project project) {
        this.team = team;
        this.project = project;
        this.id = new TeamProjectId(team.getId(), project.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        TeamProjectAssociation that = (TeamProjectAssociation) o;
        return Objects.equals(team, that.team) &&
                Objects.equals(project, that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team, project);
    }
}
