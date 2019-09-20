package com.itsol.smartoffice.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Create class model Entity base
 * <p>
 * project
 */
@Entity
@Table(name = "teamlead_project")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Teamlead_projectEntity implements Serializable {

    @Id
    private String id_project;
    private String id_team;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_team", insertable = false, updatable = false)
    private Team_leadEntity team_leadEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project", insertable = false, updatable = false)
    private ProjectsEntity projectsEntity;
}
