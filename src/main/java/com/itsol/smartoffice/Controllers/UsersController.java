package com.itsol.smartoffice.Controllers;

import com.itsol.smartoffice.Services.User.UserService;
import com.itsol.smartoffice.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

/**
 * All request to controller user
 *
 * @author thainguyen283
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class UsersController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UsersDto> users() {
        return userService.getlistuser();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/users/{user_name}")
    public UsersDto getinfouser(@PathVariable String user_name) {
        return userService.getinfouser(user_name);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/users/update")
    public boolean edituser(@RequestBody UsersDto usersDto) {
        boolean result = userService.edituser(usersDto);
        return result;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/users/delete")
    public boolean deleteuser(@RequestBody UsersDto usersDto) {
        boolean rerult = userService.deleteuser(usersDto);
        return rerult;
    }

}
