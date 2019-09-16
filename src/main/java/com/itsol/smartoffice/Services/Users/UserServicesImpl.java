package com.itsol.smartoffice.Services.Users;

import com.itsol.smartoffice.Repositories.Users.UserRepository;
import com.itsol.smartoffice.dto.UsersDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices {

    private Logger logger = LoggerFactory.getLogger(UserServicesImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean register(UsersDto usersDto) {
        if(userRepository.getUserByUserName(usersDto.getUser_name()).getUser_name() == null){
            if(userRepository.getUserByEmail(usersDto.getEmail()).getEmail() == null){
                logger.info("call userservices");
                usersDto.setFinderror("OK");
                return userRepository.register(usersDto);
            }else {
                usersDto.setFinderror("NOK");
                logger.error(" email bi trung");
            }
        }else {
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
