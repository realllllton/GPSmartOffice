package com.itsol.smartoffice.Controllers;

import com.itsol.smartoffice.Servicess.Department.DepartmentService;
import com.itsol.smartoffice.dto.DepartmentDto;
import com.sun.org.apache.xml.internal.security.keys.storage.StorageResolverException;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.login.Configuration;
import java.io.*;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(DepartmentController.BASE_URL)
public class DepartmentController {
    public static final String BASE_URL = "/apis";

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping("/department")
    public ResponseEntity<List<DepartmentDto>> getdepartall(){
        List<DepartmentDto> departmentDtos = departmentService.getdepartall();
        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
    }

//    @PostMapping("/listEmployeeIn")
//    public ResponseEntity<List<DepartmentDto>> getListEmployeeInDepartment(@RequestBody DepartmentDto departmentDto){
//        List<DepartmentDto> departmentDtos = departmentService.getListEmployeeInDepartment(departmentDto);
//        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
//    }
    @DeleteMapping("/department/{id}")
    public boolean DeleteDepartment(@PathVariable String id) {
        return departmentService.DeleteDepartment(id);
    }

    @PostMapping("/AddDepartment")
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto){
        boolean result = departmentService.addDepartment(departmentDto);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<DepartmentDto>> search(@RequestBody DepartmentDto departmentDto) {
        List<DepartmentDto> departmentDtos = departmentService.search(departmentDto);
        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
    }

    @RequestMapping("/getDepartment/{id}")
    public ResponseEntity<DepartmentDto> getdepartbyid(@PathVariable String id){
        DepartmentDto departmentDtos = departmentService.getDepartById(id);
        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
    }

    @PutMapping("/updateDepartment")
    public ResponseEntity<DepartmentDto> update(@RequestBody DepartmentDto departmentDto){
        departmentService.UpdateDepartment(departmentDto);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) throws Exception {
//        if (file == null) {
//            throw new RuntimeException("You must select the a file for uploading");
//        }
//        InputStream inputStream = file.getInputStream();
//        String originalName = file.getOriginalFilename();
//        String name = file.getName();
//        String contentType = file.getContentType();
//        long size = file.getSize();
//        // Do processing with uploaded file data in Service layer
//        return new ResponseEntity<String>(originalName, HttpStatus.OK);
//    }
//
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


}
