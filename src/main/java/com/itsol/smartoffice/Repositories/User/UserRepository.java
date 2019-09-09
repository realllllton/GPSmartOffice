package com.itsol.smartoffice.Repositories.User;

import com.itsol.smartoffice.dto.UsersDto;

import java.util.List;

public interface UserRepository {
    List<UsersDto> getlistuser();

    UsersDto getinfouser(String user_name);

    boolean edituser(UsersDto usersDto);

    boolean deleteuser(String user_name);
}
