package com.itsol.smartoffice.Repositories.Permissions;


import com.itsol.smartoffice.dto.PermissionDto;

import java.util.List;

public interface PermissionsRepository {
    List<PermissionDto> getPermissionAll();

    boolean UpdatePermissions(PermissionDto permissionDto);

    PermissionDto getPermissionById(PermissionDto permissionDto);

    List<PermissionDto> getListPermissionAOneUser(String user_name);

    boolean addPermissionsOfUser(PermissionDto permissionDto);
}
