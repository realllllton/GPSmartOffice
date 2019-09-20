package com.itsol.smartoffice.dto;

import lombok.*;

import javax.persistence.*;
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
public class TimesheetDto {

    private int id_timesheet;
    private String task;
    private Date datetime;
    private String result;
    private String notes;
    private String status;
    private String confirmed_by;
    private String user_name;
}
