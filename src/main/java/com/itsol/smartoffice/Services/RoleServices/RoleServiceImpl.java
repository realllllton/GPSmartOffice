package com.itsol.smartoffice.Services.RoleServices;

import com.itsol.smartoffice.Repositories.Role.RoleRepository;
import com.itsol.smartoffice.dto.RoleDto;
import com.itsol.smartoffice.dto.UsersDto;
import com.itsol.smartoffice.dto.Users_roleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleDto> getlistrolebyusername(String user_name) {
        logger.info("get list role by user_name");
        return roleRepository.getlistrolebyusername(user_name);
    }

    @Override
    public boolean updaterolebyusername(String user_name, int id_role) {
        logger.info("insert and update users_role by user_name");
        return roleRepository.updaterolebyusername(user_name, id_role);
    }

    @Override
    public boolean deleterolebyusername(UsersDto usersDto) {
        logger.info("delete role by user_name");
        return roleRepository.deleterolebyusername(usersDto.getUser_name());
    }
}
