package com.itsol.smartoffice.Services.Projects;

import com.itsol.smartoffice.dto.ProjectsDto;

import java.util.List;

public interface ProjectServices {
    List<ProjectsDto> getProjectall();
    boolean AddProject(ProjectsDto projectsDto);
}
