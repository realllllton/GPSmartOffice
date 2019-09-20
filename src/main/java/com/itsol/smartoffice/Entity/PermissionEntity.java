package com.itsol.smartoffice.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Create class model Entity base
 * <p>
 * project
 */
@Entity
@Table(name = "permission")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PermissionEntity {

    @Id
    private String user_name;
    private Date date;
    private String status;
    private String reason;
    private boolean activated;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_name", insertable = false, updatable = false)
    private UsersEntity usersEntity;
}
