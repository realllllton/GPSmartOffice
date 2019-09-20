package com.itsol.smartoffice.Controllers;

import com.itsol.smartoffice.Services.New.NewService;
import com.itsol.smartoffice.dto.NewsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create controller news
 *
 * @author tranloan98
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/new")
public class NewController {

    @Autowired
    private NewService newService;

    //    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')")
    @RequestMapping("/news")
    public ResponseEntity<List<NewsDto>> newgetall() {
        List<NewsDto> newsDtos = newService.newgetall();
        return new ResponseEntity<>(newsDtos, HttpStatus.OK);
    }

    @RequestMapping("/news/{id_news}")
    public NewsDto getnewinfo(@PathVariable String id_news) {
        return newService.getnewinfo(id_news);
    }

    @RequestMapping(value = "/news", method = RequestMethod.POST)
    public boolean createnew(@RequestBody NewsDto newcreate) {
        if (newService.createnew(newcreate)) {
            return true;
        }
        return false;
    }

    @RequestMapping("/news/top")
    public ResponseEntity<List<NewsDto>> getinfo() {
        List<NewsDto> newsDtos = newService.getinfo();
        return new ResponseEntity<>(newsDtos, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/news/updatenew/{id_news}", method = RequestMethod.PUT)
    public boolean updatenew(@RequestBody NewsDto newupdate, @PathVariable String id_news) {
        boolean result = newService.updatenew(newupdate, id_news);
        return result;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/news/{id_news}")
    public boolean deletenewinfo(@PathVariable String id_news) {
        return newService.deletenewinfo(id_news);
    }


}
