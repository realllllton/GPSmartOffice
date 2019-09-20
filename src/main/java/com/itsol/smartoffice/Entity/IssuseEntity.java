package com.itsol.smartoffice.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Create class model Entity base
 *
 * project
 */
@Entity
@Table(name = "issuses")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class IssuseEntity implements Serializable {

    @Id
    private String id_issuse;
    private String user_name;
    private String content_issuse;
    private Date date_issuse;
    @OneToMany(mappedBy = "issuseEntity", fetch = FetchType.LAZY)
    private List<Comment_issuseEntity> comment_issuseEntities;
    @OneToMany(mappedBy = "issuseEntity", fetch = FetchType.LAZY)
    private List<Log_issuseEntity> log_issuseEntities;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_name", insertable = false, updatable = false)
    private UsersEntity usersEntity;
}
