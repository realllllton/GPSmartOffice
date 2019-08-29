package com.itsol.smartoffice.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "timesheet")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class TimesheetEntity {

    @Id
    private int id_timesheet;
    private String task;
    private Date start_time;
    private Date end_time;
    private String result;
    private String notes;
    private String status;
    private String user_name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_name", insertable = false, updatable = false)
    private UsersEntity usersEntity;
}
