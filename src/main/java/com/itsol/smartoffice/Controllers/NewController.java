package com.itsol.smartoffice.Controllers;

import com.itsol.smartoffice.Servicess.Department.DepartmentService;
import com.itsol.smartoffice.Servicess.New.NewService;
import com.itsol.smartoffice.dto.CarDto;
import com.itsol.smartoffice.dto.DepartmentDto;
import com.itsol.smartoffice.dto.NewsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(NewController.BASE_URL)
public class NewController {
    public static final String BASE_URL = "/apis";

    private final NewService newService;

    public NewController(NewService newService) {
        this.newService = newService;
    }

    @RequestMapping("/news")
    public ResponseEntity<List<NewsDto>> newgetall(){
        List<NewsDto> newsDtos = newService.newgetall();
        return new ResponseEntity<>(newsDtos, HttpStatus.OK);
    }

    @RequestMapping("/news/{id_news}")
    public NewsDto getnewinfo(@PathVariable String id_news) {
        return newService.getnewinfo(id_news);
    }

    @RequestMapping(value = "/news", method = RequestMethod.POST)
    public boolean createnew(@RequestBody NewsDto newcreate){
        if(newService.createnew(newcreate)){
            return true;
        }
        return false;
    }

    @RequestMapping("/news/top")
    public ResponseEntity<List<NewsDto>> getinfo(){
        List<NewsDto> newsDtos = newService.getinfo();
        return new ResponseEntity<>(newsDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/news/updatenew/{id_news}", method = RequestMethod.PUT)
    public boolean updatenew(@RequestBody NewsDto newupdate, @PathVariable String id_news){
         boolean result=newService.updatenew(newupdate,id_news);
         return result;
    }

    @DeleteMapping("/news/{id_news}")
    public boolean deletenewinfo(@PathVariable String id_news) {
        return newService.deletenewinfo(id_news);
    }


}
