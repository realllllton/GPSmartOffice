package com.itsol.smartoffice.Repositories.Timesheet;

import com.itsol.smartoffice.Entity.TimesheetEntity;
import com.itsol.smartoffice.Repositories.BaseRepository;
import com.itsol.smartoffice.Utils.DataUtil;
import com.itsol.smartoffice.Utils.SQLBuilder;
import com.itsol.smartoffice.dto.TimesheetDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create Reporitory timesheet
 *
 * @author thainguyen283
 */
@Repository
public class TimesheetRepositoryImpl extends BaseRepository implements TimesheetRepository {

    private Logger logger = LoggerFactory.getLogger(TimesheetRepositoryImpl.class);

    @Override
    public List<TimesheetDto> getlisttimesheet() {
        List<TimesheetDto> resultList = null;
        try {
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_TIMESHEET, "get_list_timesheet"));
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(), new BeanPropertyRowMapper<>(TimesheetDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return resultList;
    }

    @Override
    @Transactional
    public TimesheetDto getinfotilesheet(int id_timesheet) {
        TimesheetDto reuslt = null;
        try {
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_TIMESHEET, "get_info_timesheet"));
            if (DataUtil.isNotNullAndEmptyString(String.valueOf(id_timesheet))) {
                builder.append(" and id_timesheet = :p_idtimesheet ");
                parameters.put("p_idtimesheet", String.valueOf(id_timesheet));
            }
            reuslt = getNamedParameterJdbcTemplate().queryForObject(builder.toString(), parameters, new BeanPropertyRowMapper<>(TimesheetDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return reuslt;
    }

    @Override
    public List<TimesheetDto> getlistbydatetime(String datetime) {
        List<TimesheetDto> resultList = null;
        try {
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_TIMESHEET, "get_list_by_date_time"));
            if (DataUtil.isNotNullAndEmptyString(String.valueOf(datetime))) {
                builder.append(" and datetime = :p_datetime ");
                parameters.put("p_datetime", datetime);
            }
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(), parameters, new BeanPropertyRowMapper<>(TimesheetDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return resultList;
    }

    @Override
    @Transactional
    public boolean edittimesheet(TimesheetDto timesheetDto) {
        try {
            EntityManager entityManager = getEntityManager();
            TimesheetEntity timesheetEntity = entityManager.find(TimesheetEntity.class, timesheetDto.getId_timesheet());
            timesheetEntity.setTask(timesheetDto.getTask());
            timesheetEntity.setConfirmed_by(timesheetDto.getConfirmed_by());
            timesheetEntity.setDatetime(timesheetDto.getDatetime());
            timesheetEntity.setNotes(timesheetDto.getNotes());
            timesheetEntity.setResult(timesheetDto.getResult());
            timesheetEntity.setStatus(timesheetDto.getStatus());
            timesheetEntity.setUser_name(timesheetDto.getUser_name());
            entityManager.merge(timesheetEntity);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deletetimesheet(int id_timesheet) {
        try {
            EntityManager entityManager = getEntityManager();
            TimesheetEntity timesheetEntity = entityManager.find(TimesheetEntity.class, id_timesheet);
            entityManager.remove(timesheetEntity);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    @Transactional
    public boolean addinfotimesheet(TimesheetDto timesheetDto) {
        try {
            EntityManager entityManager = getEntityManager();
            TimesheetEntity timesheetEntity = new TimesheetEntity();
            timesheetEntity.setUser_name(timesheetDto.getUser_name());
            timesheetEntity.setTask(timesheetDto.getTask());
            timesheetEntity.setDatetime(timesheetDto.getDatetime());
            timesheetEntity.setNotes(timesheetDto.getNotes());
            timesheetEntity.setStatus(timesheetDto.getStatus());
            entityManager.persist(timesheetEntity);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public List<TimesheetDto> getlisttimesheetm(String user_name) {
        List<TimesheetDto> resultList = null;
        try {
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_TIMESHEET, "get_list_timesheet"));
            if (DataUtil.isNotNullAndEmptyString(String.valueOf(user_name))) {
                builder.append(" where user_name = :p_username ");
                parameters.put("p_username", user_name);
            }
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(), parameters, new BeanPropertyRowMapper<>(TimesheetDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return resultList;
    }

    @Override
    @Transactional
    public TimesheetDto getinfotilesheetm(int id_timesheet) {
        TimesheetDto reuslt = null;
        try {
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_TIMESHEET, "get_info_timesheet"));
            if (DataUtil.isNotNullAndEmptyString(String.valueOf(id_timesheet))) {
                builder.append(" and id_timesheet = :p_idtimesheet ");
                parameters.put("p_idtimesheet", String.valueOf(id_timesheet));
            }
            reuslt = getNamedParameterJdbcTemplate().queryForObject(builder.toString(), parameters, new BeanPropertyRowMapper<>(TimesheetDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return reuslt;
    }

    @Override
    public List<TimesheetDto> getlistbydatetimem(String user_name, String datetime) {
        List<TimesheetDto> resultList = null;
        try {
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_TIMESHEET, "get_list_by_date_time"));
            if (DataUtil.isNotNullAndEmptyString(String.valueOf(datetime))) {
                builder.append(" and datetime = :p_datetime and user_name = :p_username ");
                parameters.put("p_datetime", String.valueOf(datetime));
                parameters.put("p_username", user_name);
            }
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(), parameters, new BeanPropertyRowMapper<>(TimesheetDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return resultList;
    }
}
