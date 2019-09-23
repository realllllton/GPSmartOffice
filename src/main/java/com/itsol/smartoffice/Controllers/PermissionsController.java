package com.itsol.smartoffice.Controllers;

import com.itsol.smartoffice.Services.Permissions.PermissionsService;
import com.itsol.smartoffice.dto.PermissionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apis")
public class PermissionsController {
    @Autowired
    private PermissionsService permissionsService;

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @RequestMapping("/permissions")
    public ResponseEntity<List<PermissionDto>> getdepartall(){
        List<PermissionDto> permissionDtos = permissionsService.getPermissionAll();
        return new ResponseEntity<>(permissionDtos, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @PostMapping("/permissionsById")
    public ResponseEntity<PermissionDto> getPermissionById(@RequestBody PermissionDto permissionDto){
        PermissionDto permissionDtos = permissionsService.getPermissionById(permissionDto);
        return new ResponseEntity<>(permissionDtos, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @PutMapping("/updatePermissions")
    public boolean update(@RequestBody PermissionDto permissionDto) {
        return permissionsService.UpdateEmployee(permissionDto);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @PostMapping("/permissionsOneUser")
    public ResponseEntity<List<PermissionDto>> getListPermissionAOneUser(@RequestBody String user_name){
        List<PermissionDto> permissionDtos = permissionsService.getListPermissionAOneUser(user_name);
        return new ResponseEntity<>(permissionDtos, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @PostMapping("/addPermissionsOfUser")
    public boolean add(@RequestBody PermissionDto permissionDto){
        return permissionsService.addPermissionsOfUser(permissionDto);
    }
}
