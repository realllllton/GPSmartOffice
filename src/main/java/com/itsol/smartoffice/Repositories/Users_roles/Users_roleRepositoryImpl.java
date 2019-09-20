package com.itsol.smartoffice.Repositories.Users_roles;

import com.itsol.smartoffice.Entity.Users_roleEntity;
import com.itsol.smartoffice.Repositories.BaseRepository;

import com.itsol.smartoffice.dto.Users_roleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class Users_roleRepositoryImpl extends BaseRepository implements Users_roleRepository {

    private Logger logger = LoggerFactory.getLogger(Users_roleRepositoryImpl.class);

    @Override
    @Transactional
    public boolean addrole(Users_roleDto users_roleDto) {
        try {
            EntityManager entityManager = getEntityManager();
            Users_roleEntity users_roleEntity = new Users_roleEntity();
            users_roleEntity.setId_role(users_roleDto.getId_role());
            users_roleEntity.setUser_name(users_roleDto.getUser_name());
            entityManager.persist(users_roleEntity);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }

        return false;
    }
}
