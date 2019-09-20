package com.itsol.smartoffice.Controllers;

import com.itsol.smartoffice.Services.Department.DepartmentService;
import com.itsol.smartoffice.dto.DepartmentDto;
import com.itsol.smartoffice.dto.EmployeeDto;
import com.sun.org.apache.xml.internal.security.keys.storage.StorageResolverException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.login.Configuration;
import java.io.*;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apis")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @RequestMapping("/department")
    public ResponseEntity<List<DepartmentDto>> getdepartall() {
        List<DepartmentDto> departmentDtos = departmentService.getdepartall();
        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @DeleteMapping("/department/{id}")
    public boolean DeleteDepartment(@PathVariable String id) {
        return departmentService.DeleteDepartment(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @PostMapping("/AddDepartment")
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto) {
        boolean result = departmentService.addDepartment(departmentDto);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @PostMapping("/search")
    public ResponseEntity<List<DepartmentDto>> search(@RequestBody DepartmentDto departmentDto) {
        List<DepartmentDto> departmentDtos = departmentService.search(departmentDto);
        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @RequestMapping("/getDepartment/{id}")
    public ResponseEntity<DepartmentDto> getdepartbyid(@PathVariable String id) {
        DepartmentDto departmentDtos = departmentService.getDepartById(id);
        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @PutMapping("/updateDepartment")
    public ResponseEntity<DepartmentDto> update(@RequestBody DepartmentDto departmentDto) {
        departmentService.UpdateDepartment(departmentDto);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @RequestMapping(value = "/upload2", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String uploadData(@RequestParam("file") MultipartFile file) {
        String filename = "";
        if (file == null) {
            throw new RuntimeException("You must select the a file for uploading");
        }
        try {
            filename = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(this.getFolderUpload(), filename)));
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "file da nhan" + file.getOriginalFilename();
    }

    public File getFolderUpload() {
        File folderUpload = new File(System.getProperty("user.dir") + "/Uploads");
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @PostMapping("/listCountEmployeInDepartment")
    public ResponseEntity<List<DepartmentDto>> GetListCountEmployeeInDepartment(@RequestBody String id_department) {
        List<DepartmentDto> departmentDto = departmentService.GetListCountEmployeeInDepartment(id_department);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
