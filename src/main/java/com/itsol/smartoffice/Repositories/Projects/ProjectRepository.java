package com.itsol.smartoffice.Repositories.Projects;

import com.itsol.smartoffice.dto.ProjectsDto;

import java.util.List;

public interface ProjectRepository {
    List<ProjectsDto> getProjectall();
    boolean AddProject(ProjectsDto projectsDto);
    boolean DelProject(ProjectsDto projectsDto);
}
