package com.itsol.smartoffice.Controllers;

import com.itsol.smartoffice.Services.User.UserService;
import com.itsol.smartoffice.dto.BaseDto;
import com.itsol.smartoffice.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')||hasAuthority('MEMBER')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UsersDto> users() {
        return userService.getlistuser();
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')||hasAuthority('MEMBER')")
    @RequestMapping(value = "/getquantity", method = RequestMethod.GET)
    public BaseDto getquantity() {
        return userService.getquantity();
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')||hasAuthority('MEMBER')")
    @RequestMapping(value = "/users/{user_name}", method = RequestMethod.GET)
    public UsersDto getinfouser(@PathVariable String user_name) {
        return userService.getinfouser(user_name);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')||hasAuthority('MEMBER')")
    @RequestMapping(value = "/users/usershowinfo", method = RequestMethod.POST)
    public UsersDto getinfobyusername(@RequestBody UsersDto usersDto) {
        return userService.getinfobyusername(usersDto);
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')||hasAuthority('MEMBER')")
    @RequestMapping(value = "/users/update", method = RequestMethod.POST)
    public boolean edituser(@RequestBody UsersDto usersDto) {
        boolean result = userService.edituser(usersDto);
        return result;
    }

    @PreAuthorize("hasAuthority('ADMIN')||hasAuthority('MANAGER')||hasAuthority('LEADER')||hasAuthority('MEMBER')")
    @RequestMapping(value = "/users/delete", method = RequestMethod.POST)
    public boolean deleteuser(@RequestBody UsersDto usersDto) {
        boolean rerult = userService.deleteuser(usersDto);
        return rerult;
    }

}
