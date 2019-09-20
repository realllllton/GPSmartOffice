package com.itsol.smartoffice.dto;

import lombok.*;

import javax.persistence.*;

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
public class Users_roleDto {

    private String user_name;
    private int id_role;
}
