package com.itsol.smartoffice.Controllers;

import com.itsol.smartoffice.Services.Permission.PermissionService;
import com.itsol.smartoffice.dto.PermissionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(PermissionController.BASE_URL)
public class PermissionController {

    public static final String BASE_URL = "/apis";

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/permission")
    public ResponseEntity<List<PermissionDto>> getlistpermission() {
        List<PermissionDto> permissionDtos = permissionService.getlistpermission();
        return new ResponseEntity<>(permissionDtos, HttpStatus.OK);
    }
}
