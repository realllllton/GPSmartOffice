package com.itsol.smartoffice.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UsersDto extends BaseDto {
    private String first_name;
    private String last_name;
    private String user_name;
    private String pass_word;
    private String images;
    private boolean activated;
    private String tokenactive;
    private String email;
}
