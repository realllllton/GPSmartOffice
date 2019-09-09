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
    private String images;
    private String email;
    private int phone;
    private String nick_skype;
    private String facebook_link;
    private String object;
    private String home_town;
    private String education;
    private String school;
    private String science;
    private String status;
    private Date created;
    private Date graduation_year;
    private Date last_access;
    private boolean activated;
    private String id_department;
    private String id_team;
}
