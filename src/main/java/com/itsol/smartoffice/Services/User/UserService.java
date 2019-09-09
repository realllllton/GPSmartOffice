package com.itsol.smartoffice.Services.User;

import com.itsol.smartoffice.dto.UsersDto;

import java.util.List;

public interface UserService {
    List<UsersDto> getlistuser();

    UsersDto getinfouser(String use_name);

    boolean edituser(UsersDto usersDto);

    boolean deleteuser(UsersDto usersDto);
}
