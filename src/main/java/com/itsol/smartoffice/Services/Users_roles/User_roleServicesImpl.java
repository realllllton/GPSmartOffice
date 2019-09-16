package com.itsol.smartoffice.Services.Users_roles;

import com.itsol.smartoffice.Repositories.Users_roles.Users_roleRepository;
import com.itsol.smartoffice.Services.Users.UserServicesImpl;
import com.itsol.smartoffice.dto.Users_roleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_roleServicesImpl implements User_roleServices {

    private Logger logger = LoggerFactory.getLogger(UserServicesImpl.class);

    @Autowired
    private Users_roleRepository users_roleRepository;

    @Override
    public boolean addrole(Users_roleDto users_roleDto) {
        logger.info("add role");
        return users_roleRepository.addrole(users_roleDto);
    }
}
