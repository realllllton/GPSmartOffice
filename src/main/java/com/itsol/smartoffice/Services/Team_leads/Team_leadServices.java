package com.itsol.smartoffice.Services.Team_leads;

import com.itsol.smartoffice.dto.EmployeeDto;
import com.itsol.smartoffice.dto.Team_leadDto;

import java.util.List;

public interface Team_leadServices {
    List<Team_leadDto> getTeamleadall();
    List<Team_leadDto> getTeamleadByIdproject(String IdProject);
    List<EmployeeDto> getEmployeebyIdteam(String IdTeam);
}
