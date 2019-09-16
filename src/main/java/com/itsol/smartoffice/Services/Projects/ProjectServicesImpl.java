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
    public boolean AddProject(ProjectsDto projectsDto) {
        logger.info("Call ProjectServices AddProject");
        return projectRepository.AddProject(projectsDto);
    }
}
