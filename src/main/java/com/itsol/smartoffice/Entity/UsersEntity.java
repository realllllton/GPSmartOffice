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
    private String firstname;
    private String lastname;
    private String images;
    private String email;
    private boolean activated;
    private String tokenactive;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<IssuseEntity> issuseEntities;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<TimesheetEntity> timesheetEntities;
//    @ManyToOne(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<Users_roleEntity> users_roleEntities;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<PermissionEntity> permissionEntities;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<NewsEntity> newsEntities;
}
