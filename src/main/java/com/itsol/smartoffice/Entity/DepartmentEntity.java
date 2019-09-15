package com.itsol.smartoffice.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DepartmentEntity {

    @Id
    private String id_department;
    private String name_department;
    @OneToMany(mappedBy = "departmentEntity", fetch = FetchType.LAZY)
    private List<EmployeeEntity> employeeEntities;
}
