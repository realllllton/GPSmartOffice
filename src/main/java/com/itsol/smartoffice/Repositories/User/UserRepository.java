package com.itsol.smartoffice.Repositories.User;

import com.itsol.smartoffice.dto.RoleDto;
import com.itsol.smartoffice.dto.UsersDto;
import com.itsol.smartoffice.dto.Users_roleDto;

import java.util.List;

public interface UserRepository {
    List<UsersDto> getlistuser();

    List<RoleDto> getrolebyusername(String user_name);

    UsersDto getinfouser(String user_name);

    UsersDto getinfobyusername(String user_name);

    boolean edituser(UsersDto usersDto);

    boolean deleteuser(String user_name);

    //    dung
    boolean register(UsersDto usersDto);

    boolean update(UsersDto usersDto);

    UsersDto getUserByUserName(String username);

    UsersDto getUserByEmail(String email);
}
