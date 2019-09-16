package com.itsol.smartoffice.Repositories.Users;

import com.itsol.smartoffice.dto.UsersDto;
import org.springframework.stereotype.Repository;

@Repository()
public interface UserRepository{
    boolean register(UsersDto usersDto);
    boolean update(UsersDto usersDto);
    UsersDto getUserByUserName(String username);
    UsersDto getUserByEmail(String email);
}
