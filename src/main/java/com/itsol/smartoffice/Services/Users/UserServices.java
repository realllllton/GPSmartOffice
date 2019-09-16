package com.itsol.smartoffice.Services.Users;


import com.itsol.smartoffice.dto.UsersDto;

public interface UserServices {
    boolean register(UsersDto usersDto);
    boolean update(UsersDto usersDto);
    UsersDto getUserByUserName(String username);
}
