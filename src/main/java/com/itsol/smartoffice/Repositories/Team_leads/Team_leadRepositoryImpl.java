package com.itsol.smartoffice.Repositories.Team_leads;

import com.itsol.smartoffice.Repositories.BaseRepository;
import com.itsol.smartoffice.Repositories.Projects.ProjectRepositoryImpl;
import com.itsol.smartoffice.Utils.DataUtil;
import com.itsol.smartoffice.Utils.SQLBuilder;
import com.itsol.smartoffice.dto.EmployeeDto;
import com.itsol.smartoffice.dto.Team_leadDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class Team_leadRepositoryImpl extends BaseRepository implements Team_leadRepository {

    private Logger logger = LoggerFactory.getLogger(Team_leadRepositoryImpl.class);

    @Override
    public List<Team_leadDto> getTeamleadall() {
        List<Team_leadDto> resultList = null;
        try{
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_LEAD_TEAM, "get_list_teamlead"));
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(),new BeanPropertyRowMapper<>(Team_leadDto.class));
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return resultList;
    }

    @Override
    public List<Team_leadDto> getTeamleadByIdproject(String IdProject) {
        logger.info(IdProject);
        List<Team_leadDto> resultList = null;
        try{
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_LEAD_TEAM, "get_list_teamlead_by_idproject"));
            if(DataUtil.isNotNullAndEmptyString(IdProject)){
                builder.append(" and teamlead_project.id_project = :p_id_project ");
                parameters.put("p_id_project", IdProject);
            }
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(), parameters, new BeanPropertyRowMapper<>(Team_leadDto.class));
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return resultList;
    }

    @Override
    public List<EmployeeDto> getEmployeebyIdteam(String IdTeam) {
        logger.info(IdTeam);
        List<EmployeeDto> resultList = null;
        try{
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_EMPLOYEE, "get_list_employee_by_id_team"));
            if(DataUtil.isNotNullAndEmptyString(IdTeam)){
                builder.append(" and employee.id_team = :p_id_team ");
                parameters.put("p_id_team", IdTeam);
            }
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(), parameters, new BeanPropertyRowMapper<>(EmployeeDto.class));
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return resultList;
    }
}
