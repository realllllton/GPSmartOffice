package com.itsol.smartoffice.Repositories.Role;

import com.itsol.smartoffice.Entity.Users_roleEntity;
import com.itsol.smartoffice.Repositories.BaseRepository;
import com.itsol.smartoffice.Repositories.User.UserRepositoryImpl;
import com.itsol.smartoffice.Utils.DataUtil;
import com.itsol.smartoffice.Utils.SQLBuilder;
import com.itsol.smartoffice.dto.RoleDto;
import com.itsol.smartoffice.dto.UsersDto;
import com.itsol.smartoffice.dto.Users_roleDto;
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
public class RoleRepositoryImpl extends BaseRepository implements RoleRepository {
    private Logger logger = LoggerFactory.getLogger(RoleRepositoryImpl.class);

    @Override
    public List<RoleDto> getlistrolebyusername(String user_name) {
        List<RoleDto> resultList = null;
        try {
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_ROLE, "get-list-by-username"));
            if (DataUtil.isNotNullAndEmptyString(user_name)) {
                builder.append(" and ur.user_name = :p_username ");
                parameters.put("p_username", user_name);
            }
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(), parameters, new BeanPropertyRowMapper<>(RoleDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return resultList;
    }

    @Override
    @Transactional
    public boolean updaterolebyusername(String user_name, int id_role) {
        try {
            EntityManager entityManager = getEntityManager();
            Users_roleEntity users_roleEntity = new Users_roleEntity();
            users_roleEntity.setUser_name(user_name);
            users_roleEntity.setId_role(id_role);
            entityManager.persist(users_roleEntity);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleterolebyusername(String user_name) {
        boolean result = false;
        try {
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_ROLE, "delete_role_by_username"));
            if (DataUtil.isNotNullAndEmptyString(user_name)) {
                builder.append(" and user_name = :p_username ");
                parameters.put("p_username", user_name);
            }
            getNamedParameterJdbcTemplate().update(builder.toString(), parameters);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }
}
