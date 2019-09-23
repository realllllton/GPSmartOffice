package com.itsol.smartoffice.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Create class model Entity base
 * <p>
 * project
 */
@Entity
@Table(name = "team_lead")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Team_leadEntity {
    @Id
    private String id_team;
    private String name_team;
    private int quantity;
    private String id_project;
    @OneToMany(mappedBy = "team_leadEntity", fetch = FetchType.LAZY)
    private List<EmployeeEntity> employeeEntities;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project", insertable = false, updatable = false)
    private ProjectsEntity projectsEntity;
}
