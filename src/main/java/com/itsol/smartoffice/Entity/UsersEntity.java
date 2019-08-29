package com.itsol.smartoffice.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UsersEntity {

    @Id
    private String user_name;
    private String pass_word;
    private String full_name;
    private String images;
    private String email;
    private int phone;
    private String nick_facebook;
    private String facebook_link;
    private String object;
    private String home_town;
    private String education;
    private String school;
    private String science;
    private boolean activated;
    private Date graduation_year;
    private String id_employee;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<IssuseEntity> issuseEntities;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<TimesheetEntity> timesheetEntities;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employee", insertable = false, updatable = false)
    private EmployeeEntity employeeEntity;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<Users_roleEntity> users_roleEntities;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<PermissionEntity> permissionEntities;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<NewsEntity> newsEntities;
}
