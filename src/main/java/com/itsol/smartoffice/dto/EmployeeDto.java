package com.itsol.smartoffice.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class EmployeeDto {

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
}
