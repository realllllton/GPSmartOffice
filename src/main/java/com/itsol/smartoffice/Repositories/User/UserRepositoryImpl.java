package com.itsol.smartoffice.Repositories.User;

import com.itsol.smartoffice.Entity.UsersEntity;
import com.itsol.smartoffice.Repositories.BaseRepository;
import com.itsol.smartoffice.Utils.DataUtil;
import com.itsol.smartoffice.Utils.SQLBuilder;
import com.itsol.smartoffice.dto.CarDto;
import com.itsol.smartoffice.dto.UsersDto;
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
public class UserRepositoryImpl extends BaseRepository implements UserRepository {

    private Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @Override
    public List<UsersDto> getlistuser() {
        List<UsersDto> reultList = null;
        try {
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_USERS, "get_list_user"));
            reultList = getNamedParameterJdbcTemplate().query(builder.toString(), new BeanPropertyRowMapper<>(UsersDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return reultList;
    }

    @Override
    public UsersDto getinfouser(String user_name) {
        UsersDto usersDto = null;
        try {
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_USERS, "get_info_user"));
            if (DataUtil.isNotNullAndEmptyString(user_name)) {
                builder.append(" and users_role.user_name = :p_username ");
                parameters.put("p_username", user_name);
            }
            usersDto = getNamedParameterJdbcTemplate().queryForObject(builder.toString(), parameters, new BeanPropertyRowMapper<>(UsersDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return usersDto;
    }

    @Override
    public boolean edituser(UsersDto usersDto) {
        try {
            EntityManager entityManager = getEntityManager();
            UsersEntity usersEntity = new UsersEntity();
            usersEntity.setEmail(usersDto.getEmail());
            usersEntity.setImages(usersDto.getImages());
            usersEntity.setBlock(usersDto.isBlock());
            usersEntity.setActivated(usersDto.isActivated());
            entityManager.merge(usersEntity);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteuser(String user_name) {
        try {
            EntityManager entityManager = getEntityManager();
            UsersEntity usersEntity = entityManager.find(UsersEntity.class, user_name);
            entityManager.remove(usersEntity);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }
}
