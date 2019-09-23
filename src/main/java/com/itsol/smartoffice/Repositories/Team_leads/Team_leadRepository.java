package com.itsol.smartoffice.Repositories.Team_leads;

import com.itsol.smartoffice.dto.EmployeeDto;
import com.itsol.smartoffice.dto.Team_leadDto;

import java.util.List;

public interface Team_leadRepository {
    List<Team_leadDto> getTeamleadall();
    Team_leadDto getTeamleadbyIdteamlead(String IdTeam);
    List<Team_leadDto> getTeamleadByIdproject(String IdProject);
    List<EmployeeDto> getEmployeebyIdteam(String IdTeam);
    List<EmployeeDto> getEmployeebyIdteamisnull();
    List<Team_leadDto> getTeamleadByidprojectnull();
    boolean AddTeamLead(Team_leadDto team_leadDto);
    boolean UpdateTeamLead(Team_leadDto team_leadDto);
    boolean DeleteTeamLead(String id_team);
}
