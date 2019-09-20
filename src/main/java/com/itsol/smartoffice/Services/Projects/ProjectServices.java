package com.itsol.smartoffice.Services.Projects;

import com.itsol.smartoffice.dto.ProjectsDto;

import java.util.List;

public interface ProjectServices {
    List<ProjectsDto> getProjectall();
    ProjectsDto getListProjectById(String IdProject);
    boolean AddProject(ProjectsDto projectsDto);
    boolean DelProject(String Id_project);
    boolean UpdateProject(ProjectsDto projectsDto);
}
