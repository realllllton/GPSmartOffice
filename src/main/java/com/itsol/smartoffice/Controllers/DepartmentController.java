package com.itsol.smartoffice.Controllers;

import com.itsol.smartoffice.Services.Departments.DepartmentService;
import com.itsol.smartoffice.dto.DepartmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(DepartmentController.BASE_URL)
public class DepartmentController {
    public static final String BASE_URL = "/apis";
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/department")
    public ResponseEntity<List<DepartmentDto>> getdepartall() {
        List<DepartmentDto> departmentDtos = departmentService.getdepartall();
        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
    }
}
