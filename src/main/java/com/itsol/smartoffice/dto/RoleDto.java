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
public class RoleDto {

    private int id_role;
    private String name_role;
}
