package com.itsol.smartoffice.Controllers;


import com.itsol.smartoffice.Services.Team_leads.Team_leadServices;
import com.itsol.smartoffice.dto.EmployeeDto;
import com.itsol.smartoffice.dto.ProjectsDto;
import com.itsol.smartoffice.dto.Team_leadDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apis")
public class TeamLeadController {

    private Logger logger = LoggerFactory.getLogger(TeamLeadController.class);
    @Autowired
    private Team_leadServices team_leadServices;

    @GetMapping("/teamlead")
    public ResponseEntity<List<Team_leadDto>> getTeamlead(){
        List<Team_leadDto> team_leadDtos = team_leadServices.getTeamleadall();
        return new ResponseEntity<>(team_leadDtos,HttpStatus.OK);
    }
    @GetMapping("/teamleadbyidproject/{idproject}")
    public ResponseEntity<List<Team_leadDto>> getTeamleadbyidproject(@PathVariable String idproject){
        List<Team_leadDto> team_leadDtos = team_leadServices.getTeamleadByIdproject(idproject);
        return new ResponseEntity<>(team_leadDtos, HttpStatus.OK);
    }
    @GetMapping("/employeebyidteamlead/{idteam}")
    public  ResponseEntity<List<EmployeeDto>> getEmployeebyidteam(@PathVariable String idteam){
        List<EmployeeDto> employeeDtos = team_leadServices.getEmployeebyIdteam(idteam);
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

}
