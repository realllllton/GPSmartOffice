package com.itsol.smartoffice.Repositories.User;

import com.itsol.smartoffice.Entity.UsersEntity;
import com.itsol.smartoffice.Repositories.BaseRepository;
import com.itsol.smartoffice.Utils.DataUtil;
import com.itsol.smartoffice.Utils.SQLBuilder;
import com.itsol.smartoffice.dto.RoleDto;
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
    public List<RoleDto> getrolebyusername(String user_name) {
        List<RoleDto> rolelist = new ArrayList<>();
        try {
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_USERS, "get_role_by_username"));
            if (DataUtil.isNotNullAndEmptyString(user_name)) {
                builder.append(" and users_role.user_name = :p_username ");
                parameters.put("p_username", user_name);
            }
            rolelist = getNamedParameterJdbcTemplate().query(builder.toString(), parameters, new BeanPropertyRowMapper<>(RoleDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return rolelist;
    }

    @Override
    public UsersDto getinfouser(String user_name) {
        UsersDto usersDto = null;
        try {
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_USERS, "get_info_user"));
            if (DataUtil.isNotNullAndEmptyString(user_name)) {
                builder.append(" and users_role.user_name = :p_username group by users.user_name ");
                parameters.put("p_username", user_name);
            }
            usersDto = getNamedParameterJdbcTemplate().queryForObject(builder.toString(), parameters, new BeanPropertyRowMapper<>(UsersDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return usersDto;
    }

    @Override
    public UsersDto getinfobyusername(String user_name) {
        UsersDto usersDto = null;
        try {
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_USERS, "get_info_user_username"));
            if (DataUtil.isNotNullAndEmptyString(user_name)) {
                builder.append(" and user_name = :p_username group by user_name ");
                parameters.put("p_username", user_name);
            }
            usersDto = getNamedParameterJdbcTemplate().queryForObject(builder.toString(), parameters, new BeanPropertyRowMapper<>(UsersDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return usersDto;
    }

    @Override
    @Transactional
    public boolean edituser(UsersDto usersDto) {
        try {
            EntityManager entityManager = getEntityManager();
            UsersEntity usersEntity = entityManager.find(UsersEntity.class, usersDto.getUser_name());
            usersEntity.setFirst_name(usersDto.getFirst_name());
            usersEntity.setLast_name(usersDto.getLast_name());
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

    //    dung
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
            //usersDto.setPass_word(randomString(8));
            //usersDto.setTokenactive(randomString(7));
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
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_USERS, "get_user_by_username"));
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
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_USERS, "get_user_by_username"));
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
