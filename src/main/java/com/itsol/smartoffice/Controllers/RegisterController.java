package com.itsol.smartoffice.Controllers;

import com.itsol.smartoffice.Services.Emails.EmailService;

import com.itsol.smartoffice.Services.Users.UserServices;
import com.itsol.smartoffice.Services.Users_roles.User_roleServices;
import com.itsol.smartoffice.dto.UsersDto;
import com.itsol.smartoffice.dto.Users_roleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@CrossOrigin("*")
@RequestMapping("/apis")
public class RegisterController {
    private Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private EmailService emailService;
    @Autowired
    private UserServices userServices;
    @Autowired
    private User_roleServices user_roleServices;

    @PostMapping("/register")
    public ResponseEntity<UsersDto> registeruser(@RequestBody UsersDto usersDto) {
        boolean users = userServices.register(usersDto);
        try {
            emailService.sendMail(usersDto.getEmail(), "password for login: " + usersDto.getPass_word(), "click here to active account http://localhost:8080/apis/confirm/" + usersDto.getTokenactive() + "/" + usersDto.getUser_name());
        } catch (MessagingException e) {
//                e.printStackTrace();
        }
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    @GetMapping("/confirm/{token}/{username}")
    public ResponseEntity<UsersDto> confirmuser(@PathVariable String token, @PathVariable String username) {
        UsersDto usersDto = userServices.getUserByUserName(username);
        if (usersDto.getTokenactive().equals(token)) {
            usersDto.setActivated(true);
            usersDto.setBlock(true);
            userServices.update(usersDto);

            Users_roleDto users_roleDto = new Users_roleDto();
            users_roleDto.setUser_name(usersDto.getUser_name());
            users_roleDto.setId_role(4);
            user_roleServices.addrole(users_roleDto);
        }
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }
}
