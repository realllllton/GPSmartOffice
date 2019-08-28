package com.itsol.smartoffice.Repositories.Car;

import com.itsol.smartoffice.Entity.CarEntity;
import com.itsol.smartoffice.Repositories.BaseRepository;
import com.itsol.smartoffice.Utils.DataUtil;
import com.itsol.smartoffice.Utils.SQLBuilder;
import com.itsol.smartoffice.dto.CarDto;
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
public class CarRepositoryImpl extends BaseRepository implements CarRepository {

    private Logger logger = LoggerFactory.getLogger(CarRepository.class);

    @Override
    public List<CarDto> getcarall() {
        List<CarDto> resultList = null;
        try {
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_CAR, "get_list_car"));
            resultList = getNamedParameterJdbcTemplate().query(builder.toString(), new BeanPropertyRowMapper<>(CarDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return resultList;
    }

    @Override
    public CarDto getcarinfo(String numberplate) {
        CarDto carDto = new CarDto();
        try {
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_CAR, "get_info_car"));
            if (DataUtil.isNotNullAndEmptyString(numberplate)) {
                builder.append(" and numberplate = :p_name ");
                parameters.put("p_name", numberplate);
            }
            carDto = getNamedParameterJdbcTemplate().queryForObject(builder.toString(), parameters, new BeanPropertyRowMapper<>(CarDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return carDto;
    }

    @Override
    @Transactional
    public boolean deletecarinfo(String numberplate) {
        try {
            EntityManager entityManager = getEntityManager();
            CarEntity carEntity = entityManager.find(CarEntity.class, numberplate);
            entityManager.remove(carEntity);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }
}
