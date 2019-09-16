package com.itsol.smartoffice.Services.User;

import com.itsol.smartoffice.Repositories.User.UserRepository;
import com.itsol.smartoffice.dto.UsersDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UsersDto> getlistuser() {
        logger.info("get list user");
        return userRepository.getlistuser();
    }

    @Override
    public UsersDto getinfouser(String use_name) {
        logger.info("get info users");
        return userRepository.getinfouser(use_name);
    }

    @Override
    public UsersDto getinfobyusername(UsersDto usersDto) {
        logger.info("get info user by user_name");
        return userRepository.getinfobyusername(usersDto.getUser_name());
    }

    @Override
    public boolean edituser(UsersDto usersDto) {
        logger.info("edit user");
        return userRepository.edituser(usersDto);
    }

    @Override
    public boolean deleteuser(UsersDto usersDto) {
        logger.info("delete user");
        return userRepository.deleteuser(usersDto.getUser_name());
    }
}
