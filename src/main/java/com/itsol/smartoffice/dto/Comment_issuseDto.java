package com.itsol.smartoffice.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Create class model base
 * <p>
 * project
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Comment_issuseDto {

    private String id_comment;
    private String id_issuse;
    private String user_name;
    private Date date_comment;
    private String content_comment;
}
