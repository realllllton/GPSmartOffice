package com.itsol.smartoffice.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class TimesheetDto {

    private int id_timesheet;
    private String task;
    private Date start_time;
    private Date end_time;
    private String result;
    private String notes;
    private String status;
    private String user_name;
}
