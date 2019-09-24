package com.itsol.smartoffice.Repositories.Permissions;



import com.itsol.smartoffice.Entity.PermissionEntity;
import com.itsol.smartoffice.Repositories.BaseRepository;
import com.itsol.smartoffice.Utils.SQLBuilder;
import com.itsol.smartoffice.dto.PermissionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PermissionsRepositoryImpl extends BaseRepository implements  PermissionsRepository{
   private Logger logger = LoggerFactory.getLogger(PermissionsRepositoryImpl.class);

   @Override
   public List<PermissionDto> getPermissionAll(){
      List<PermissionDto> resultList = null;
      try {
         StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_PERMISSIONS, "get_list_permissions"));
         resultList = getNamedParameterJdbcTemplate().query(builder.toString(), new BeanPropertyRowMapper<>(PermissionDto.class));
      } catch (Exception e){
         logger.error(e.getMessage(), e);
      }
      return resultList;
   }

   @Override
   public PermissionDto getPermissionById(PermissionDto permissionDto){
      try {
         Map<String, Object> parameters = new HashMap<>();
         StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_PERMISSIONS, "get_list_permissions_one_user"));
         builder.append(" and p.user_name like :1 and p.date like :2 ");
         parameters.put("1", permissionDto.getUser_name());
         parameters.put("2", permissionDto.getDate());
         getNamedParameterJdbcTemplate().query(builder.toString(), parameters, new BeanPropertyRowMapper<>(PermissionDto.class));
      } catch (Exception e){
         logger.error(e.getMessage(), e);
      }
      return permissionDto;
   }

   @Override
   public List<PermissionDto> getListPermissionAOneUser(String user_name){
      PermissionDto permissionDto = new PermissionDto();
      List<PermissionDto> resultList = null;
      try {
         Map<String, Object> parameters = new HashMap<>();
         StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_PERMISSIONS, "get_list_permissions_one_user"));
            builder.append(" and p.user_name like :? order by p.date DESC ");
            parameters.put("?", user_name);
            logger.info(""+parameters);
            logger.info("id truyen vao"+ user_name);
         resultList = getNamedParameterJdbcTemplate().query(builder.toString(), parameters, new BeanPropertyRowMapper<>(PermissionDto.class));
      } catch (Exception e){
         logger.error(e.getMessage(), e);
      }
      return resultList;
   }

   @Override
   @Transactional
   public boolean UpdatePermissions(PermissionDto permissionDto) {
      logger.info("object nhan " + permissionDto);
      try {
         List<PermissionDto> resultList = getPermissionAll();
         logger.info("list " + resultList);
         Map<String, Object> parameters = new HashMap<>();
         StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_PERMISSIONS, "update_permissions"));
         for(int i=0; i < resultList.size(); i++){
            if(permissionDto.getDate() != null && permissionDto.getUser_name() != null && permissionDto.getUser_name().equals(resultList.get(i).getUser_name()) && permissionDto.getDate().equals(resultList.get(i).getDate()) )
            {
               logger.info("object nhan " + resultList.get(i).getDate());
               logger.info("object nhan " + resultList.get(i).getUser_name());
               builder.append(" set p.reason = :p.reason, p.status = :p.status, p.activated = :p.activated where p.user_name = :p.user_name and p.date = :p.date");
               parameters.put("p.reason", permissionDto.getReason());
               parameters.put("p.status", permissionDto.getStatus());
               parameters.put("p.activated", permissionDto.isActivated());
               parameters.put("p.user_name", (permissionDto.getUser_name()));
               parameters.put("p.date", permissionDto.getDate());
               getNamedParameterJdbcTemplate().update(builder.toString(), parameters);
               return true;
            }
         }
      } catch (Exception e){
         logger.error(e.getMessage(), e);
      }
      return false;
   }

   @Override
   @Transactional
   public boolean addPermissionsOfUser(PermissionDto permissionDto) {
      try {
         LocalDateTime localDate = LocalDateTime.now();
         logger.info("time hien tai"+localDate);
         EntityManager entityManager = getEntityManager();
         PermissionEntity permissionEntity = new PermissionEntity();
         permissionEntity.setUser_name(permissionDto.getUser_name());
         permissionEntity.setDate(permissionDto.getDate());
         permissionEntity.setStatus(permissionDto.getStatus());
         permissionEntity.setReason(permissionDto.getReason());
         permissionEntity.setActivated(permissionDto.isActivated());
         entityManager.persist(permissionEntity);
         return true;
      } catch (Exception e) {
         logger.error(e.getMessage(), e);
      }
      return false;
   }
}
