package com.itsol.smartoffice.Services.Permission;

import com.itsol.smartoffice.Repositories.Permission.PermissionRepository;
import com.itsol.smartoffice.dto.PermissionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    private Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<PermissionDto> getlistpermission() {
        logger.info("get list permission");
        return permissionRepository.getlistpermission();
    }
}
