package com.itsol.smartoffice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UsersDto extends BaseDto {

    private String user_name;
    private String pass_word;
    private String full_name;
    private String images;
    private String email;
    private boolean block;
    private boolean activated;
    private int id_role;
    private String name_role;
}
