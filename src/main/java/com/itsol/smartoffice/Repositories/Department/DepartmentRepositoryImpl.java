package com.itsol.smartoffice.Repositories.Department;

import com.itsol.smartoffice.Repositories.BaseRepository;
import com.itsol.smartoffice.Utils.SQLBuilder;
import com.itsol.smartoffice.dto.DepartmentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
