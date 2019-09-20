package com.itsol.smartoffice.Controllers;

import com.itsol.smartoffice.Services.Projects.ProjectServices;
import com.itsol.smartoffice.dto.ProjectsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apis")
public class ProjectControler {
    private Logger logger = LoggerFactory.getLogger(ProjectControler.class);

    @Autowired
    private ProjectServices projectServices;

    @GetMapping("/project")
    public ResponseEntity<List<ProjectsDto>> getProject(){
        List<ProjectsDto> projectsDtos = projectServices.getProjectall();
        return new ResponseEntity<>(projectsDtos, HttpStatus.OK);
    }
    @GetMapping("/getprojectbyid/{id_project}")
    public ResponseEntity<ProjectsDto> getProjectById(@PathVariable String id_project){
        ProjectsDto project = projectServices.getListProjectById(id_project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
    @PostMapping("/addproject")
    public ResponseEntity<ProjectsDto> addProject(@RequestBody ProjectsDto projectsDto){
        boolean addproject = projectServices.AddProject(projectsDto);
        return new ResponseEntity<>(projectsDto, HttpStatus.OK);
    }
    @DeleteMapping("/delproject/{id_project}")
    public ResponseEntity<ProjectsDto> delProject(@PathVariable String id_project){
        boolean delproject = projectServices.DelProject(id_project);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/updproject")
    public  ResponseEntity<ProjectsDto> updProject(@RequestBody ProjectsDto projectsDto){
        boolean updproject = projectServices.UpdateProject(projectsDto);
        return new ResponseEntity<>(projectsDto, HttpStatus.OK);
    }


}
