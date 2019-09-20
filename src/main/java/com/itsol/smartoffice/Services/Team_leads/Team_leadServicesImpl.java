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
    public List<Team_leadDto> getTeamleadByIdproject(String IdProject) {
        logger.info("Call Team_leadServces getTeamleadbyProjectID");
        return team_leadRepository.getTeamleadByIdproject(IdProject);
    }

    @Override
    public List<EmployeeDto> getEmployeebyIdteam(String IdTeam) {
        return team_leadRepository.getEmployeebyIdteam(IdTeam);
    }
}
