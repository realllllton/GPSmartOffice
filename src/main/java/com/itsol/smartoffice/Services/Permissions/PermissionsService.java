package com.itsol.smartoffice.Services.Permissions;

import com.itsol.smartoffice.dto.PermissionDto;

import java.util.List;

public interface PermissionsService {
    List<PermissionDto> getPermissionAll();
    Boolean UpdateEmployee(PermissionDto permissionDto);
    PermissionDto getPermissionById(PermissionDto permissionDto);
    List<PermissionDto> getListPermissionAOneUser(String user_name);
    boolean addPermissionsOfUser(PermissionDto permissionDto);
}
