package com.itsol.smartoffice.Servicess.New;

import com.itsol.smartoffice.Repositories.New.NewRepository;
import com.itsol.smartoffice.dto.NewsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewServiceImpl  implements NewService{

    private Logger logger = LoggerFactory.getLogger(NewServiceImpl.class);

    private final NewRepository newRepository;

    public NewServiceImpl(NewRepository newRepository) {
        this.newRepository = newRepository;
    }


   public List<NewsDto> newgetall(){
       logger.info("get list all new");
       return newRepository.newgetall();
   }

    public NewsDto getnewinfo(String id_news){
        logger.info("get infor new ");
        return newRepository.getnewinfo(id_news);
    }

    public List<NewsDto> getinfo(){
        logger.info("info new top");
        return newRepository.getinfo();
    }

    public boolean createnew(NewsDto newcreate){
        logger.info("insert new ");
        boolean result = false;
        if(newRepository.createnew(newcreate)){
            result=true;
        }
        return result;
    }

    public boolean updatenew(NewsDto newupdate, String id_news){
        logger.info("update new");
        return newRepository.updatenew(newupdate, id_news);
    }

    public boolean deletenewinfo(String id_news){
        logger.info("delete new");
        return newRepository.deletenewinfo(id_news);
    }
}
