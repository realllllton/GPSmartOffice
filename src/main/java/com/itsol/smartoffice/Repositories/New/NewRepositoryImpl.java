package com.itsol.smartoffice.Repositories.New;

import com.itsol.smartoffice.Entity.NewsEntity;
import com.itsol.smartoffice.Repositories.BaseRepository;
import com.itsol.smartoffice.Utils.DataUtil;
import com.itsol.smartoffice.Utils.SQLBuilder;
import com.itsol.smartoffice.dto.NewsDto;
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
@Transactional
public class NewRepositoryImpl extends BaseRepository implements NewRepository {

    private Logger logger = LoggerFactory.getLogger(NewRepositoryImpl.class);

    @Override
    public List<NewsDto> newgetall() {
        List<NewsDto> resultnew = null;

        try {
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_NEW, "get_list_new"));
            resultnew = getNamedParameterJdbcTemplate().query(builder.toString(), new BeanPropertyRowMapper<>(NewsDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return resultnew;
    }

    @Override
    public List<NewsDto> getinfo() {
        List<NewsDto> resultnew = null;

        try {
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_NEW, "getinfonew"));
            resultnew = getNamedParameterJdbcTemplate().query(builder.toString(), new BeanPropertyRowMapper<>(NewsDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return resultnew;
    }

    @Override
    public NewsDto getnewinfo(String id_news) {
        NewsDto result = null;

        try {
            Map<String, String> parameters = new HashMap<>();
            StringBuilder builder = new StringBuilder(SQLBuilder.getSqlFromFile(SQLBuilder.SQL_MODUL_NEW, "get_list_new"));
            if (DataUtil.isNotNullAndEmptyString(id_news)) {
                builder.append(" where id_news = :p_name ");
                parameters.put("p_name", id_news);
            }
            result = getNamedParameterJdbcTemplate().queryForObject(builder.toString(), parameters, new BeanPropertyRowMapper<>(NewsDto.class));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public boolean createnew(NewsDto newcreate) {
        boolean result = false;
        try {
            EntityManager entityManager = getEntityManager();
            NewsEntity newEntity = new NewsEntity();

            newEntity.setId_news(newcreate.getId_news());
            newEntity.setImages(newcreate.getImages());
            newEntity.setDate(newcreate.getDate());
            newEntity.setTitle(newcreate.getTitle());
            newEntity.setBrief(newcreate.getBrief());
            newEntity.setDetail(newcreate.getDetail());
            newEntity.setUser_name(newcreate.getUser_name());

            getEntityManager().persist(newEntity);
            result = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;

    }

    @Override
    public boolean updatenew(NewsDto newupdate, String id_news) {
        try {
            EntityManager entityManager = getEntityManager();

            NewsEntity newsEntity = entityManager.find(NewsEntity.class, id_news);
//            NewsDto newinfor = getnewinfo(id_news);
//            newinfor.setId_news(newupdate.getId_news());
            newsEntity.setImages(newupdate.getImages());
            newsEntity.setDate(newupdate.getDate());
            newsEntity.setTitle(newupdate.getTitle());
            newsEntity.setBrief(newupdate.getBrief());
            newsEntity.setDetail(newupdate.getDetail());
            newsEntity.setUser_name(newupdate.getUser_name());

            entityManager.merge(newsEntity);
            return true;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean deletenewinfo(String id_news) {

        try {
            EntityManager entityManager = getEntityManager();
            NewsEntity newEntity = entityManager.find(NewsEntity.class, id_news);
            entityManager.remove(newEntity);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }
}
