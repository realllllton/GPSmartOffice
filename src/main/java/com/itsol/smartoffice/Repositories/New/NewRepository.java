package com.itsol.smartoffice.Repositories.New;

import com.itsol.smartoffice.dto.NewsDto;

import java.util.List;

public interface NewRepository {
    List<NewsDto> newgetall();

    NewsDto getnewinfo(String id_news);

    List<NewsDto> getinfo();

    boolean createnew(NewsDto newcreate);

    boolean updatenew(NewsDto newupdate, String id_news);

    boolean deletenewinfo(String id_news);
}
