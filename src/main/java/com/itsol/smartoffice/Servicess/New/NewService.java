package com.itsol.smartoffice.Servicess.New;

import com.itsol.smartoffice.dto.NewsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewService {
    List<NewsDto> newgetall();

    NewsDto getnewinfo(String id_news);

    List<NewsDto> getinfo();

    boolean createnew(NewsDto newcreate);

    boolean updatenew(NewsDto newupdate, String id_news);

    boolean deletenewinfo(String id_news);
}
