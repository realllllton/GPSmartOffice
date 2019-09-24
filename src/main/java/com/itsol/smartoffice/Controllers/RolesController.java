package com.itsol.smartoffice.Controllers;

import com.itsol.smartoffice.Services.RoleServices.RoleService;
import com.itsol.smartoffice.dto.RoleDto;
import com.itsol.smartoffice.dto.UsersDto;
import com.itsol.smartoffice.dto.Users_roleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create controller roles for users
 *
 * @author thainguyen283
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RolesController {

    @Autowired
    private RoleService roleService;

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')||hasAuthority('MEMBER')")
    @RequestMapping(value = "/role/getlistbyuser/{user_name}", method = RequestMethod.GET)
    public List<RoleDto> getlistrolebyuser(@PathVariable String user_name) {
        return roleService.getlistrolebyusername(user_name);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/role/updaterolebyusername/{user_name}", method = RequestMethod.POST)
    public boolean updaterolebyusername(@PathVariable String user_name, @RequestBody int id_role) {
        return roleService.updaterolebyusername(user_name, id_role);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/role/deletebyusername")
    public boolean deletebyusername(@RequestBody UsersDto usersDto) {
        return roleService.deleterolebyusername(usersDto);
    }
}
