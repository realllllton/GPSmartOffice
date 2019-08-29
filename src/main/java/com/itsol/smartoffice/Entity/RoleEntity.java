package com.itsol.smartoffice.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class RoleEntity {

    @Id
    private int id_role;
    private String name_role;
    @OneToMany(mappedBy = "roleEntity", fetch = FetchType.LAZY)
    private List<Users_roleEntity> users_roleEntities;
}
