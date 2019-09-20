package com.itsol.smartoffice.dto;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
public class IssuseDto implements Serializable {

    private String id_issuse;
    private String user_name;
    private String content;
    private Date date_issuse;
}
