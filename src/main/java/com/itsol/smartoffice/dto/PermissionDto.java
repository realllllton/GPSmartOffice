package com.itsol.smartoffice.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PermissionDto {

    private String user_name;
    private Date date;
    private String status;
    private String reason;
    private boolean activated;
}
