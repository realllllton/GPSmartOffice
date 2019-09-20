package com.itsol.smartoffice.Controllers;

import com.itsol.smartoffice.Servicess.Permissions.PermissionsService;
import com.itsol.smartoffice.dto.PermissionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PermissionsController.BASE_URL)
public class PermissionsController {
    public static final String BASE_URL = "/apis";
    private PermissionsService permissionsService;

    public PermissionsController(PermissionsService permissionsService) {
        this.permissionsService = permissionsService;
    }

    @RequestMapping("/permissions")
    public ResponseEntity<List<PermissionDto>> getdepartall(){
        List<PermissionDto> permissionDtos = permissionsService.getPermissionAll();
        return new ResponseEntity<>(permissionDtos, HttpStatus.OK);
    }

    @PostMapping("/permissionsById")
    public ResponseEntity<PermissionDto> getPermissionById(@RequestBody String user_name){
        PermissionDto permissionDtos = permissionsService.getPermissionById(user_name);
        return new ResponseEntity<>(permissionDtos, HttpStatus.OK);
    }

    @PutMapping("/updatePermissions")
    public boolean update(@RequestBody PermissionDto permissionDto) {
        return permissionsService.UpdateEmployee(permissionDto);
    }

    @PostMapping("/permissionsOneUser")
    public ResponseEntity<List<PermissionDto>> getListPermissionAOneUser(@RequestBody String user_name){
        List<PermissionDto> permissionDtos = permissionsService.getListPermissionAOneUser(user_name);
        return new ResponseEntity<>(permissionDtos, HttpStatus.OK);
    }

    @PostMapping("/addPermissionsOfUser")
    public boolean add(@RequestBody PermissionDto permissionDto){
        return permissionsService.addPermissionsOfUser(permissionDto);
    }
}
