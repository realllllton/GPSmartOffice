package com.itsol.smartoffice.Repositories.Projects;

import com.itsol.smartoffice.Entity.ProjectsEntity;
import com.itsol.smartoffice.Repositories.BaseRepository;
import com.itsol.smartoffice.Utils.DataUtil;
import com.itsol.smartoffice.Utils.SQLBuilder;
import com.itsol.smartoffice.dto.ProjectsDto;
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
public class ProjectRepositoryImpl extends BaseRepository implements ProjectRepository {

    private Logger logger = LoggerFactory.getLogger(ProjectRepositoryImpl.class);

    @Override
    public List<ProjectsDto> getProjectall() {
        List<ProjectsDto> resultList = null;
        try{
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_PROJECT, "get_list_project"));
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(),new BeanPropertyRowMapper<>(ProjectsDto.class));
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return resultList;
    }

    @Override
    public ProjectsDto getListProjectById(String IdProject) {
        ProjectsDto projectsDto = new ProjectsDto();
        try {
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_PROJECT, "get_list_project"));
            if (DataUtil.isNotNullAndEmptyString(IdProject)) {
                builder.append(" and id_project = :p_id_project");
                parameters.put("p_id_project", IdProject);
            }
            projectsDto = getNamedParameterJdbcTemplate().queryForObject(builder.toString(), parameters, new BeanPropertyRowMapper<>(ProjectsDto.class));
        } catch (Exception e) {
            logger.info("Không tìm thấy project can tim");
        };
        return projectsDto;
    }

    @Override
    @Transactional
    public boolean AddProject(ProjectsDto projectsDto) {
        try{
            EntityManager entityManager = getEntityManager();
            ProjectsEntity projectsEntity = new ProjectsEntity();
            projectsEntity.setId_project(projectsDto.getId_project());
            projectsEntity.setName_project(projectsDto.getName_project());
            projectsEntity.setStart_time(projectsDto.getStart_time());
            projectsEntity.setEnd_time(projectsDto.getEnd_time());
            entityManager.persist(projectsEntity);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    @Transactional
    public boolean DelProject(String Id_project) {
        try{
            EntityManager entityManager = getEntityManager();
            ProjectsEntity projectsEntity = entityManager.find(ProjectsEntity.class, Id_project);
            entityManager.remove(projectsEntity);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    @Transactional
    public boolean UpdateProject(ProjectsDto projectsDto) {
        try{
            EntityManager entityManager = getEntityManager();
            ProjectsEntity projectsEntity = new ProjectsEntity();
            projectsEntity.setId_project(projectsDto.getId_project());
            projectsEntity.setName_project(projectsDto.getName_project());
            projectsEntity.setStart_time(projectsDto.getStart_time());
            projectsEntity.setEnd_time(projectsDto.getEnd_time());
            entityManager.merge(projectsEntity);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return false;
    }

}
