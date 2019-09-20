package com.itsol.smartoffice.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProjectsDto extends BaseDto {
    private String id_project;
    private String name_project;
    private Date start_time;
    private Date end_time;
}
