package com.itsol.smartoffice.Services.User;

import com.itsol.smartoffice.dto.BaseDto;
import com.itsol.smartoffice.dto.RoleDto;
import com.itsol.smartoffice.dto.UsersDto;

import java.util.List;

public interface UserService {
    List<UsersDto> getlistuser();

    List<RoleDto> getrolebyusername(String user_name);

    UsersDto getinfouser(String use_name);

    UsersDto getinfobyusername(UsersDto usersDto);

    boolean edituser(UsersDto usersDto);

    boolean deleteuser(UsersDto usersDto);

    BaseDto getquantity();

    //    dung
    boolean register(UsersDto usersDto);

    boolean update(UsersDto usersDto);

    UsersDto getUserByUserName(String username);
}
