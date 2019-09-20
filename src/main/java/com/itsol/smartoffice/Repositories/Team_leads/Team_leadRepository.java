package com.itsol.smartoffice.Repositories.Team_leads;

import com.itsol.smartoffice.dto.EmployeeDto;
import com.itsol.smartoffice.dto.Team_leadDto;
import com.itsol.smartoffice.dto.Teamlead_projectDto;

import java.util.List;

public interface Team_leadRepository {
    List<Team_leadDto> getTeamleadall();
    List<Team_leadDto> getTeamleadByIdproject(String IdProject);
    List<EmployeeDto> getEmployeebyIdteam(String IdTeam);
}
