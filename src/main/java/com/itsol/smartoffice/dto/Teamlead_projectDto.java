package com.itsol.smartoffice.dto;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Teamlead_projectDto implements Serializable {

    private String id_project;
    private String id_team;
}
