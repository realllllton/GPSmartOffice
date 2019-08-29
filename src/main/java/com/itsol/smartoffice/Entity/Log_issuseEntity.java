package com.itsol.smartoffice.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "log_issuse")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Log_issuseEntity implements Serializable {

    @Id
    private String id_log;
    private String id_issuse;
    private Date date_created;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_issuse", insertable = false, updatable = false)
    private IssuseEntity issuseEntity;
}
