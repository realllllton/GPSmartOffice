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
    private String full_name;
    private String images;
    private String email;
    private int phone;
    private String nick_facebook;
    private String facebook_link;
    private String object;
    private String home_town;
    private String education;
    private String school;
    private String science;
    private boolean activated;
    private Date graduation_year;
    private String id_employee;
}
