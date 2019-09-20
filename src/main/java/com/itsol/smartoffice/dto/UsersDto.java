package com.itsol.smartoffice.dto;

import lombok.*;

/**
 * Create class model base
 *
 * project
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UsersDto extends BaseDto {

    private String user_name;
    private String pass_word;
    private String first_name;
    private String last_name;
    private String images;
    private String email;
    private boolean block;
    private boolean activated;
    private int id_role;
    private String name_role;
    private String tokenactive;
}
