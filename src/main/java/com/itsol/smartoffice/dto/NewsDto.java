package com.itsol.smartoffice.dto;

import lombok.*;

import java.util.Date;

/**
 * Create class model base
 *
 * project
 */
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
    private String detail;
    private String user_name;
}
