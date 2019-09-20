package com.itsol.smartoffice.dto;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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
public class Log_issuseDto implements Serializable {

    private String id_log;
    private String id_issuse;
    private Date date_created;
}
