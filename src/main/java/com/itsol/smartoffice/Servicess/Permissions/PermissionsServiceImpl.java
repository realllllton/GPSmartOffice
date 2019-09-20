package com.itsol.smartoffice.Servicess.Permissions;

import com.itsol.smartoffice.Repositories.Permissions.PermissionsRepository;
import com.itsol.smartoffice.Repositories.Permissions.PermissionsRepositoryImpl;
import com.itsol.smartoffice.Servicess.Employee.EmployeeServiceImpl;
import com.itsol.smartoffice.dto.PermissionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionsServiceImpl implements PermissionsService{
    private Logger logger = LoggerFactory.getLogger(PermissionsServiceImpl.class);

    private final PermissionsRepository permissionsRepository;

    public PermissionsServiceImpl(PermissionsRepository permissionsRepository) {
        this.permissionsRepository = permissionsRepository;
    }
    @Override
    public List<PermissionDto> getPermissionAll() {
        logger.info("get list all Permissions");
        return permissionsRepository.getPermissionAll();
    }
    @Override
    public Boolean UpdateEmployee(PermissionDto permissionDto) {
        logger.info(""+permissionDto);
       return permissionsRepository.UpdatePermissions(permissionDto);
    }
    @Override
    public PermissionDto getPermissionById(String user_name) {
        logger.info("get list all Permissions by"+ user_name);
        return permissionsRepository.getPermissionById(user_name);
    }
    @Override
    public List<PermissionDto> getListPermissionAOneUser(String user_name){
        logger.info("get list Permissions one user");
        return permissionsRepository.getListPermissionAOneUser(user_name);
    }
    @Override
    public boolean addPermissionsOfUser(PermissionDto permissionDto){
        logger.info("add permission of user");
        return permissionsRepository.addPermissionsOfUser(permissionDto);
    }
}
