package com.itsol.smartoffice.Services.Projects;

import com.itsol.smartoffice.Repositories.Projects.ProjectRepository;
import com.itsol.smartoffice.dto.ProjectsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServicesImpl implements ProjectServices {

    private Logger logger = LoggerFactory.getLogger(ProjectServicesImpl.class);

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectsDto> getProjectall() {
        logger.info("Call ProjectServices getProjectall");
        return projectRepository.getProjectall();
    }

    @Override
    public ProjectsDto getListProjectById(String IdProject) {
        logger.info("Call ProjectServices getListProjectById");
        return projectRepository.getListProjectById(IdProject);
    }

    @Override
    public boolean AddProject(ProjectsDto projectsDto) {
        if(projectRepository.getListProjectById(projectsDto.getId_project()).getId_project()== null){
            logger.info("Call ProjectServices AddProject");
            projectsDto.setFinderror("OK");
            return projectRepository.AddProject(projectsDto);
        }else {
            logger.error("Trung Id project");
            projectsDto.setFinderror("NOK");
        }
       return false;
    }

    @Override
    public boolean DelProject(String Id_project) {
        logger.info("Call ProjectServices DeleteProject");
        return projectRepository.DelProject(Id_project);
    }

    @Override
    public boolean UpdateProject(ProjectsDto projectsDto) {
        logger.info("Call ProjectServices UpdateProject");
        return projectRepository.UpdateProject(projectsDto);
    }
}
