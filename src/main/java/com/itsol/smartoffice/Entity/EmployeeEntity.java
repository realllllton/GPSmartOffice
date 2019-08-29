package com.itsol.smartoffice.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class EmployeeEntity {

    @Id
    private String id_employee;
    private String full_name;
    private String email;
    private int phone;
    private String status;
    private Date created;
    private Date last_access;
    private boolean activated;
    private String id_department;
    private String id_team;
    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.LAZY)
    private List<UsersEntity> usersEntities;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_department", insertable = false, updatable = false)
    private DepartmentEntity departmentEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_team", insertable = false, updatable = false)
    private Team_leadEntity team_leadEntity;
}
