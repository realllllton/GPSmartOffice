package com.itsol.smartoffice.Services.User;

import com.itsol.smartoffice.Repositories.User.UserRepository;
import com.itsol.smartoffice.dto.BaseDto;
import com.itsol.smartoffice.dto.RoleDto;
import com.itsol.smartoffice.dto.UsersDto;
import com.itsol.smartoffice.dto.Users_roleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<RoleDto> getrolebyusername(String user_name) {
        logger.info("get list role by username");
        return userRepository.getrolebyusername(user_name);
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

    @Override
    public BaseDto getquantity() {
        logger.info("getquantity user blocked");
        return userRepository.getquantity();
    }

    //    dung
    @Override
    public boolean register(UsersDto usersDto) {
        if (userRepository.getUserByUserName(usersDto.getUser_name()).getUser_name() == null) {
            if (userRepository.getUserByEmail(usersDto.getEmail()).getEmail() == null) {
                logger.info("call userservices");
                usersDto.setFinderror("OK");
                return userRepository.register(usersDto);
            } else {
                usersDto.setFinderror("NOK");
                logger.error(" email bi trung");
            }
        } else {
            usersDto.setFinderror("NOK");
            logger.error("ten dang nhap bi trungg");
        }
        return false;

    }

    @Override
    public boolean update(UsersDto usersDto) {
        return userRepository.update(usersDto);
    }

    @Override
    public UsersDto getUserByUserName(String username) {
        return userRepository.getUserByUserName(username);
    }
}
