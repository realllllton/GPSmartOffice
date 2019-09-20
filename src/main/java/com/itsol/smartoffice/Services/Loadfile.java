package com.itsol.smartoffice.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class Loadfile {

    Logger logger = LoggerFactory.getLogger(Loadfile.class);
    private final Path imguser = Paths.get("./Uploads");

    public Resource loadFile(String filename, Path path) {
        try {
            Path file = path.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                logger.error("FAIL!");
            }
        } catch (MalformedURLException e) {
            logger.error("FAIL!");
        }
        return null;
    }

    public Resource loadimguser(String nameFile) {
        return loadFile(nameFile, imguser);
    }


}
