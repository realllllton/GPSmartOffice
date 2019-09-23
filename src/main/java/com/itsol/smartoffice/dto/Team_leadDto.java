package com.itsol.smartoffice.dto;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
public class Team_leadDto extends BaseDto {

    private String id_team;
    private String name_team;
    private int quantity;
    private String id_project;
}
