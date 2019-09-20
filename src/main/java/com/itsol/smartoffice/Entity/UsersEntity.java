package com.itsol.smartoffice.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersEntity {

    @Id
    private String user_name;
    private String first_name;
    private String last_name;
    private String pass_word;
    private boolean activated;
    private String tokenactive;
    private String images;
    private String email;
    private boolean block;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<IssuseEntity> issuseEntities;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<TimesheetEntity> timesheetEntities;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<Users_roleEntity> users_roleEntities;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<PermissionEntity> permissionEntities;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<NewsEntity> newsEntities;
}