package com.itsol.smartoffice.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users_role")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Users_roleEntity {

    @Id
    private String user_name;
    private int id_role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_name", insertable = false, updatable = false)
    private UsersEntity usersEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role", insertable = false, updatable = false)
    private RoleEntity roleEntity;
}
