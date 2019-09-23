package com.itsol.smartoffice.Services.Team_leads;

import com.itsol.smartoffice.Repositories.Team_leads.Team_leadRepository;
import com.itsol.smartoffice.dto.EmployeeDto;
import com.itsol.smartoffice.dto.Team_leadDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Team_leadServicesImpl implements Team_leadServices {

    private Logger logger = LoggerFactory.getLogger(Team_leadServicesImpl.class);

    @Autowired
    private Team_leadRepository team_leadRepository;

    @Override
    public List<Team_leadDto> getTeamleadall() {
        logger.info("Call Team_leadServices getTTeamleadall ");
        return team_leadRepository.getTeamleadall();
    }

    @Override
    public Team_leadDto getTeamleadbyIdteamlead(String IdTeam) {
        logger.info("Call getTeamleadbyIdTeamlead");
        return team_leadRepository.getTeamleadbyIdteamlead(IdTeam);
    }

    @Override
    public List<Team_leadDto> getTeamleadByIdproject(String IdProject) {
        logger.info("Call Team_leadServces getTeamleadbyProjectID");
        return team_leadRepository.getTeamleadByIdproject(IdProject);
    }

    @Override
    public List<EmployeeDto> getEmployeebyIdteam(String IdTeam) {
        return team_leadRepository.getEmployeebyIdteam(IdTeam);
    }

    @Override
    public List<EmployeeDto> getEmployeebyIdteamisnull() {
        logger.info("Call getEmployeebtIdteamisnull");
        return team_leadRepository.getEmployeebyIdteamisnull();
    }

    @Override
    public List<Team_leadDto> getTeamleadByidprojectnull() {
        logger.info("Call getTeamleadbyIdprojectnull");
        return team_leadRepository.getTeamleadByidprojectnull();
    }

    @Override
    public boolean AddTeamLead(Team_leadDto team_leadDto) {
        if(team_leadRepository.getTeamleadbyIdteamlead(team_leadDto.getId_team()).getId_team()== null){
            logger.info("Call AddTeamLeadServices");
            team_leadDto.setFinderror("OK");
            return team_leadRepository.AddTeamLead(team_leadDto);
        }else {
            logger.error("trung id");
            team_leadDto.setFinderror("NOK");
        }
        return false;
    }
    @Override
    public boolean UpdateTeamLead(Team_leadDto team_leadDto) {
        logger.info("Call UpdateTeam");
        return team_leadRepository.UpdateTeamLead(team_leadDto);
    }

    @Override
    public boolean DeleteTeamLead(String id_team) {
        logger.info("Call deleteTeam");
        return team_leadRepository.DeleteTeamLead(id_team);
    }

}
