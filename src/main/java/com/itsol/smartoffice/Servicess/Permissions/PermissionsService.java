package com.itsol.smartoffice.Servicess.Permissions;

import com.itsol.smartoffice.dto.PermissionDto;

import java.util.List;

public interface PermissionsService {
    List<PermissionDto> getPermissionAll();
    Boolean UpdateEmployee(PermissionDto permissionDto);
    PermissionDto getPermissionById(String user_name);
    List<PermissionDto> getListPermissionAOneUser(String user_name);
    boolean addPermissionsOfUser(PermissionDto permissionDto);
}
