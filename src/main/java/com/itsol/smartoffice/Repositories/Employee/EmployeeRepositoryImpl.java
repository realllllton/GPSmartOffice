package com.itsol.smartoffice.Repositories.Employee;

import com.itsol.smartoffice.Entity.EmployeeEntity;
import com.itsol.smartoffice.Repositories.Department.DepartmentRepositoryImpl;
import com.itsol.smartoffice.Utils.DataUtil;
import com.itsol.smartoffice.Utils.SQLBuilder;
import com.itsol.smartoffice.dto.EmployeeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.itsol.smartoffice.Repositories.BaseRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepositoryImpl extends BaseRepository implements  EmployeeRepository{

    private Logger logger = LoggerFactory.getLogger(DepartmentRepositoryImpl.class);

    @Override
    public List<EmployeeDto> getEmployeeAll() {
        List<EmployeeDto> resultList = null;
        try {
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_EMPLOYEE, "get_list_employee"));
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(), new BeanPropertyRowMapper<>(EmployeeDto.class));
        } catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return resultList;
    }



    @Override
    @Transactional
    public boolean DeleteEmployee(String id_employee) {
        try{
            EntityManager entityManager = getEntityManager();
            EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, id_employee);
            logger.info("EmployeeRepository"+employeeEntity);
            entityManager.remove(employeeEntity);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    @Transactional
    public boolean addEmployee(EmployeeDto employeeDto) {
        try {
            EntityManager entityManager = getEntityManager();
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setId_employee(employeeDto.getId_employee());
            employeeEntity.setFull_name(employeeDto.getFull_name());
            employeeEntity.setImages(employeeDto.getImages());
            employeeEntity.setEmail(employeeDto.getEmail());
            employeeEntity.setPhone(employeeDto.getPhone());
            employeeEntity.setObject(employeeDto.getObject());
            employeeEntity.setStatus(employeeDto.getStatus());
            employeeEntity.setCreated(employeeDto.getCreated());
            employeeEntity.setLast_access(employeeDto.getLast_access());
            employeeEntity.setHome_town(employeeDto.getHome_town());
            employeeEntity.setEducation(employeeDto.getEducation());
            employeeEntity.setScience(employeeDto.getScience());
            employeeEntity.setSchool(employeeDto.getSchool());
            employeeEntity.setNick_skype(employeeDto.getNick_skype());
            employeeEntity.setFacebook_link(employeeDto.getFacebook_link());
            employeeEntity.setGraduation_year(employeeDto.getGraduation_year());
            employeeEntity.setActivated(employeeDto.isActivated());
            employeeEntity.setId_department(employeeDto.getId_department());
            employeeEntity.setId_team(employeeDto.getId_team());
            entityManager.persist(employeeEntity);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    @Transactional
    public EmployeeDto getEmployeeById(String id_employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        EntityManager entityManager = getEntityManager();
        EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, id_employee);
        logger.info("EmployeeEntity"+employeeEntity);
        employeeDto.setId_employee(employeeEntity.getId_employee());
        employeeDto.setFull_name(employeeEntity.getFull_name());
        employeeDto.setImages(employeeEntity.getImages());
        employeeDto.setEmail(employeeEntity.getEmail());
        employeeDto.setPhone(employeeEntity.getPhone());
        employeeDto.setObject(employeeEntity.getObject());
        employeeDto.setStatus(employeeEntity.getStatus());
        employeeDto.setCreated(employeeEntity.getCreated());
        employeeDto.setLast_access(employeeEntity.getLast_access());
        employeeDto.setHome_town(employeeEntity.getHome_town());
        employeeDto.setEducation(employeeEntity.getEducation());
        employeeDto.setScience(employeeEntity.getScience());
        employeeDto.setSchool(employeeEntity.getSchool());
        employeeDto.setNick_skype(employeeEntity.getNick_skype());
        employeeDto.setFacebook_link(employeeEntity.getFacebook_link());
        employeeDto.setGraduation_year(employeeEntity.getGraduation_year());
        employeeDto.setActivated(employeeEntity.isActivated());
        employeeDto.setId_department(employeeEntity.getId_department());
        employeeDto.setId_team(employeeEntity.getId_team());
        entityManager.persist(employeeEntity);
        return employeeDto;
    }

    @Override
    @Transactional
    public boolean UpdateEmployee(EmployeeDto employeeDto) {
        try {
            EntityManager entityManager = getEntityManager();
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setId_employee(employeeDto.getId_employee());
            employeeEntity.setFull_name(employeeDto.getFull_name());
            employeeEntity.setImages(employeeDto.getImages());
            employeeEntity.setEmail(employeeDto.getEmail());
            employeeEntity.setPhone(employeeDto.getPhone());
            employeeEntity.setObject(employeeDto.getObject());
            employeeEntity.setStatus(employeeDto.getStatus());
            employeeEntity.setCreated(employeeDto.getCreated());
            employeeEntity.setLast_access(employeeDto.getLast_access());
            employeeEntity.setHome_town(employeeDto.getHome_town());
            employeeEntity.setEducation(employeeDto.getEducation());
            employeeEntity.setScience(employeeDto.getScience());
            employeeEntity.setSchool(employeeDto.getSchool());
            employeeEntity.setNick_skype(employeeDto.getNick_skype());
            employeeEntity.setFacebook_link(employeeDto.getFacebook_link());
            employeeEntity.setGraduation_year(employeeDto.getGraduation_year());
            employeeEntity.setActivated(employeeDto.isActivated());
            employeeEntity.setId_department(employeeDto.getId_department());
            employeeEntity.setId_team(employeeDto.getId_team());
            entityManager.merge(employeeEntity);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    @Transactional
    public List<EmployeeDto> getListEmployeeInDepartment(String id) {
        EmployeeDto employeeDto = new EmployeeDto();
        List<EmployeeDto> resultList = null;
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_EMPLOYEE, "get_list_employee_in_department"));
            if(DataUtil.isNotNullAndEmptyString(id)){
                builder.append(" and d.id_department like :? ");
                parameters.put("?", DataUtil.removeWildcardCharacters(id));
                logger.info(""+parameters);
                logger.info("id truyen vao"+ id);
            }
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(), parameters, new BeanPropertyRowMapper<>(EmployeeDto.class));
        } catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return resultList;
    }

    @Override
    public List<EmployeeDto> getListEmployeeNotInDepartment() {
        List<EmployeeDto> resultList = null;
        try {
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_EMPLOYEE, "get_list_employee_not_in_department"));
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(), new BeanPropertyRowMapper<>(EmployeeDto.class));
        } catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return resultList;
    }


    @Override
    @Transactional
    public List<EmployeeDto> Search(EmployeeDto employeeDto){
        logger.info("ob qua ripo"+ employeeDto.getFull_name());
        List<EmployeeDto> resultList = null;
        try{
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_EMPLOYEE, "get_list_employee"));
            if(DataUtil.isNotNullAndEmptyString(employeeDto.getId_employee())){
                builder.append(" and e.id_employee like :e.id_employee ");
                parameters.put("e.id_employee", DataUtil.removeWildcardCharacters(employeeDto.getId_employee()));
                logger.info(""+parameters);
            }
            if(DataUtil.isNotNullAndEmptyString(employeeDto.getFull_name())){
                builder.append(" and e.full_name like :e.full_name ");
                parameters.put("e.full_name", DataUtil.removeWildcardCharacters(employeeDto.getFull_name()));
            }
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(), parameters, new BeanPropertyRowMapper<>(EmployeeDto.class));
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return resultList;
    }
}
