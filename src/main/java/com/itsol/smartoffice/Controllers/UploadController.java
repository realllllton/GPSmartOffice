package com.itsol.smartoffice.Controllers;

import com.itsol.smartoffice.Services.Loadfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Create controller upload file(images)
 *
 * @author thainguyen283
 */
@RestController
@CrossOrigin("*")
@RequestMapping("")
public class UploadController {

    @Autowired
    private Loadfile loadFile;

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = loadFile.loadimguser(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    void uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = "";
        try {
            fileName = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(this.getFolderUpload(), fileName)));
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public File getFolderUpload() {
        File folderUpload = new File(System.getProperty("user.dir") + "/Uploads");
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }
}

