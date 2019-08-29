package com.itsol.smartoffice.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class NewsDto {

    private String id_news;
    private String images;
    private String title;
    private Date date;
    private String brief;
    private String user_name;
}
