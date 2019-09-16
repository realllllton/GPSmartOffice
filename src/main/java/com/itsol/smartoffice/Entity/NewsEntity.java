package com.itsol.smartoffice.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "news")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class NewsEntity {

    @Id
    private String id_news;
    private String images;
    private String title;
    private Date date;
    private String brief;
    private String detail;
    private String user_name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_name", insertable = false, updatable = false)
    private UsersEntity usersEntity;

}
