package com.itsol.smartoffice.Services.RoleServices;

import com.itsol.smartoffice.dto.RoleDto;
import com.itsol.smartoffice.dto.UsersDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> getlistrolebyusername(String user_name);

    boolean updaterolebyusername(String user_name, int id_role);

    boolean deleterolebyusername(UsersDto usersDto);
}
