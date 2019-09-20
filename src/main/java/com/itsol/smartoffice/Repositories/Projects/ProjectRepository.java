package com.itsol.smartoffice.Repositories.Projects;

import com.itsol.smartoffice.dto.ProjectsDto;

import java.util.List;

public interface ProjectRepository {
    List<ProjectsDto> getProjectall();
    ProjectsDto getListProjectById(String IdProject);
    boolean AddProject(ProjectsDto projectsDto);
    boolean DelProject(String Id_project);
    boolean UpdateProject (ProjectsDto projectsDto);
}
