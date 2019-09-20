package com.itsol.smartoffice.Repositories.Users;

import com.itsol.smartoffice.Entity.UsersEntity;
import com.itsol.smartoffice.Repositories.BaseRepository;
import com.itsol.smartoffice.Utils.DataUtil;
import com.itsol.smartoffice.Utils.SQLBuilder;
import com.itsol.smartoffice.dto.UsersDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.*;

@Repository
public class UserRepositoryImpl extends BaseRepository implements UserRepository {

    private Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);


    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Random rnd = new Random();

    String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    @Override
    @Transactional
    public boolean register(UsersDto usersDto) {
        try {
            EntityManager entityManager = getEntityManager();
            UsersEntity usersEntity = new UsersEntity();
            usersEntity.setUser_name(usersDto.getUser_name());
            usersEntity.setFirst_name(usersDto.getFirst_name());
            usersEntity.setLast_name(usersDto.getLast_name());
            usersEntity.setEmail(usersDto.getEmail());
            usersEntity.setActivated(usersDto.isActivated());
            usersDto.setPass_word(randomString(8));
            usersDto.setTokenactive(randomString(7));
            usersEntity.setPass_word(usersDto.getPass_word());
            usersEntity.setTokenactive(usersDto.getTokenactive());
            entityManager.persist(usersEntity);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(UsersDto usersDto) {
        try {
            EntityManager entityManager = getEntityManager();
            UsersEntity usersEntity = new UsersEntity();
            usersEntity.setUser_name(usersDto.getUser_name());
            usersEntity.setFirst_name(usersDto.getFirst_name());
            usersEntity.setLast_name(usersDto.getLast_name());
            usersEntity.setEmail(usersDto.getEmail());
            usersEntity.setActivated(usersDto.isActivated());
            usersDto.setPass_word(randomString(8));
            usersDto.setTokenactive(randomString(7));
            usersEntity.setPass_word(usersDto.getPass_word());
            usersEntity.setTokenactive(usersDto.getTokenactive());
            usersEntity.setBlock(usersDto.isBlock());
            entityManager.merge(usersEntity);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public UsersDto getUserByUserName(String username) {
        UsersDto usersDto = new UsersDto();
        try {
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_USER, "get_user_by_username"));
            if (DataUtil.isNotNullAndEmptyString(username)) {
                builder.append(" and user_name = :p_name");
                parameters.put("p_name", username);
            }
            usersDto = getNamedParameterJdbcTemplate().queryForObject(builder.toString(), parameters, new BeanPropertyRowMapper<>(UsersDto.class));
        } catch (Exception e) {
            logger.info("Không tìm thấy đối tượng có username đã nhập, cho phép đăng ký");
        }
        return usersDto;
    }

    @Override
    public UsersDto getUserByEmail(String email) {
        UsersDto usersDto = new UsersDto();
        try {
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_USER, "get_user_by_username"));
            if (DataUtil.isNotNullAndEmptyString(email)) {
                builder.append(" and email = :p_email");
                parameters.put("p_email", email);
            }
            usersDto = getNamedParameterJdbcTemplate().queryForObject(builder.toString(), parameters, new BeanPropertyRowMapper<>(UsersDto.class));
        } catch (Exception e) {
            logger.info("Không tìm thấy email đã nhập, cho phép đăng ký");
        }
        return usersDto;
    }


}