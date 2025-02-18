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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apis")
public class TeamLeadController {
    private Logger logger = LoggerFactory.getLogger(TeamLeadController.class);
    @Autowired
    private Team_leadServices team_leadServices;

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @GetMapping("/teamlead")
    public ResponseEntity<List<Team_leadDto>> getTeamlead() {
        List<Team_leadDto> team_leadDtos = team_leadServices.getTeamleadall();
        return new ResponseEntity<>(team_leadDtos, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @GetMapping("/teamleadbyidteam/{idteam}")
    public ResponseEntity<Team_leadDto> getTeamleadbyidteam(@PathVariable String idteam) {
        Team_leadDto team_leadDto = team_leadServices.getTeamleadbyIdteamlead(idteam);
        return new ResponseEntity<>(team_leadDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @GetMapping("/teamleadbyidproject/{idproject}")
    public ResponseEntity<List<Team_leadDto>> getTeamleadbyidproject(@PathVariable String idproject) {
        List<Team_leadDto> team_leadDtos = team_leadServices.getTeamleadByIdproject(idproject);
        return new ResponseEntity<>(team_leadDtos, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @GetMapping("/employeebyidteamlead/{idteam}")
    public ResponseEntity<List<EmployeeDto>> getEmployeebyidteam(@PathVariable String idteam) {
        List<EmployeeDto> employeeDtos = team_leadServices.getEmployeebyIdteam(idteam);
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @GetMapping("/employeebyidteamleadisnull")
    public ResponseEntity<List<EmployeeDto>> getEmployeebyidteamnull() {
        List<EmployeeDto> employeeDtos = team_leadServices.getEmployeebyIdteamisnull();
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @GetMapping("/teamleadbyidprojectisnull")
    public  ResponseEntity<List<Team_leadDto>> getTeamleadbyidprojectnull(){
        List<Team_leadDto> team_leadDtos = team_leadServices.getTeamleadByidprojectnull();
        return new ResponseEntity<>(team_leadDtos,HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @PostMapping("/addteamlead")
    public ResponseEntity<Team_leadDto> addTeamlead(@RequestBody Team_leadDto team_leadDto) {
        boolean teamlead = team_leadServices.AddTeamLead(team_leadDto);
        return new ResponseEntity<>(team_leadDto, HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @PutMapping("/updateteamlead")
    public ResponseEntity<Team_leadDto> updateTeamlead(@RequestBody Team_leadDto team_leadDto) {
        boolean teamlead = team_leadServices.UpdateTeamLead(team_leadDto);
        return new ResponseEntity<>(team_leadDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')")
    @DeleteMapping("/deleteteamlead/{id_team}")
    public ResponseEntity<Team_leadDto> delteTeamlead(@PathVariable String id_team) {
        boolean teamlead = team_leadServices.DeleteTeamLead(id_team);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
