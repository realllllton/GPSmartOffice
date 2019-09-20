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
@ToString
public class Team_leadEntity {

    @Id
    private String id_team;
    private String name_team;
    private int quantity;
    @OneToMany(mappedBy = "team_leadEntity", fetch = FetchType.LAZY)
    private List<EmployeeEntity> employeeEntities;
    @OneToMany(mappedBy = "team_leadEntity", fetch = FetchType.LAZY)
    private List<Teamlead_projectEntity> teamlead_projectEntities;
}
