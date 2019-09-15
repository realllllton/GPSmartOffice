package com.itsol.smartoffice.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UsersDto {
    private String user_name;
    private String pass_word;
    private String first_name;
    private String last_name;
    private String images;
    private String email;
    private boolean activated;
    private String tokenactive;
}
