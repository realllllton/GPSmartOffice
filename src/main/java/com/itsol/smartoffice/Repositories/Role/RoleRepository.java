package com.itsol.smartoffice.Repositories.Role;

import com.itsol.smartoffice.dto.RoleDto;
import com.itsol.smartoffice.dto.Users_roleDto;

import java.util.List;

public interface RoleRepository {
    List<RoleDto> getlistrolebyusername(String user_nme);

    boolean updaterolebyusername(String user_name, int id_role);

    boolean deleterolebyusername(String user_name);
}
