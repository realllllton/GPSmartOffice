package com.itsol.smartoffice.Services.User;

import com.itsol.smartoffice.Entity.UsersEntity;
import com.itsol.smartoffice.dto.UsersDto;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserService {
    List<UsersDto> getlistuser();

    UsersDto getinfouser(String use_name);

    UsersDto getinfobyusername(UsersDto usersDto);

    boolean edituser(UsersDto usersDto);

    boolean deleteuser(UsersDto usersDto);
}
