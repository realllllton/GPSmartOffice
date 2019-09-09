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
    private String images;
    private String email;
    private boolean block;
    private boolean activated;
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
