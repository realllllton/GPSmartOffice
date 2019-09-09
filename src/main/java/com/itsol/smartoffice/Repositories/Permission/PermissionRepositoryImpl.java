package com.itsol.smartoffice.Repositories.Permission;

import com.itsol.smartoffice.Repositories.BaseRepository;
import com.itsol.smartoffice.Utils.SQLBuilder;
import com.itsol.smartoffice.dto.PermissionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PermissionRepositoryImpl extends BaseRepository implements PermissionRepository {

    private Logger logger = LoggerFactory.getLogger(PermissionRepository.class);

    @Override
    public List<PermissionDto> getlistpermission() {
        List<PermissionDto> resultList = null;
        try {
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_PERMISSION, "get_list_permission"));
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(), new BeanPropertyRowMapper<>(PermissionDto.class));
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return resultList;
    }
}
