package com.itsol.smartoffice.Repositories.Department;

import com.itsol.smartoffice.Entity.DepartmentEntity;
import com.itsol.smartoffice.Repositories.BaseRepository;
import com.itsol.smartoffice.Utils.DataUtil;
import com.itsol.smartoffice.Utils.SQLBuilder;
import com.itsol.smartoffice.dto.DepartmentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DepartmentRepositoryImpl extends BaseRepository implements DepartmentRepository {

    private Logger logger = LoggerFactory.getLogger(DepartmentRepositoryImpl.class);

    @Override
    public List<DepartmentDto> getdepartall() {
        List<DepartmentDto> resultList = null;
        try {
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_DEPARTMENT, "get_list_department"));
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(), new BeanPropertyRowMapper<>(DepartmentDto.class));
        } catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return resultList;
    }

    @Override
    @Transactional
    public List<DepartmentDto> Search(DepartmentDto departmentDto){
        List<DepartmentDto> resultList = null;
        try{
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_DEPARTMENT, "get_list_department"));
            if(DataUtil.isNotNullAndEmptyString(departmentDto.getId_department())){
                builder.append(" and d.id_department like :d.id_department ");
                parameters.put("d.id_department", DataUtil.removeWildcardCharacters(departmentDto.getId_department()));
                logger.info(""+parameters);
            }
            if(DataUtil.isNotNullAndEmptyString(departmentDto.getName_department())){
                builder.append(" and d.name_department like :d.name_department ");
                parameters.put("d.name_department", DataUtil.removeWildcardCharacters(departmentDto.getName_department()));
            }
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(), parameters, new BeanPropertyRowMapper<>(DepartmentDto.class));
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return resultList;
    }

    @Override
    @Transactional
    public boolean DeleteDepartment(String id_department){
        try{
            EntityManager entityManager = getEntityManager();
            DepartmentEntity departmentEntity = entityManager.find(DepartmentEntity.class, id_department);
            logger.info(""+departmentEntity);
            entityManager.remove(departmentEntity);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    @Transactional
    public DepartmentDto getDepartmentById(String id_department){
        DepartmentDto departmentDto = new DepartmentDto();
        EntityManager entityManager = getEntityManager();
        DepartmentEntity departmentEntity = entityManager.find(DepartmentEntity.class, id_department);
        departmentDto.setId_department(departmentEntity.getId_department());
        departmentDto.setName_department(departmentEntity.getName_department());
        return departmentDto;
    }

    @Override
    @Transactional
    public boolean addDepartment(DepartmentDto departmentDto) {
        try {
            EntityManager entityManager = getEntityManager();
            DepartmentEntity departmentEntity = new DepartmentEntity();
            departmentEntity.setId_department(departmentDto.getId_department());
            departmentEntity.setName_department(departmentDto.getName_department());
            entityManager.persist(departmentEntity);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }
    @Override
    @Transactional
    public boolean UpdateDepartment(DepartmentDto departmentDto){
        logger.info(departmentDto.getId_department());
        logger.info(departmentDto.getName_department());
        try {
            EntityManager entityManager = getEntityManager();
            DepartmentEntity departmentEntity = new DepartmentEntity();
            departmentEntity.setId_department(departmentDto.getId_department());
            departmentEntity.setName_department(departmentDto.getName_department());
            entityManager.merge(departmentEntity);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    @Transactional
    public List<DepartmentDto> GetCountListEmployeeInDepartment(String id_department) {
        DepartmentDto departmentDto = new DepartmentDto();
        List<DepartmentDto> resultList = null;
        try {
            Map<String, Object> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_DEPARTMENT, "count_employee_in_department"));
            if(DataUtil.isNotNullAndEmptyString(id_department)){
                builder.append(" and d.id_department like :? GROUP BY d.id_department ");
                parameters.put("?", DataUtil.removeWildcardCharacters(id_department));
                logger.info(""+parameters);
                logger.info("id truyen vao"+ id_department);
            }
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(), parameters, new BeanPropertyRowMapper<>(DepartmentDto.class));
        } catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return resultList;
    }

}
