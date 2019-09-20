package com.itsol.smartoffice.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Create class model Entity base
 *
 * project
 */
@Entity
@Table(name = "comment_issuse")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Comment_issuseEntity {

    @Id
    private String id_comment;
    private String id_issuse;
    private String user_name;
    private Date date_comment;
    private String content_comment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_issuse", insertable = false, updatable = false)
    private IssuseEntity issuseEntity;
}
