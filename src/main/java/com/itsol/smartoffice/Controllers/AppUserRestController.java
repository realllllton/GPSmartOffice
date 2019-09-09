package com.itsol.smartoffice.Controllers;

import com.itsol.smartoffice.Services.User.UserService;
import com.itsol.smartoffice.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller for authentication and user details. All the web services of
 * this rest controller will be only accessible for ADMIN users only
 * 
 * @author Sarath Muraleedharan
 *
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/apis")
public class AppUserRestController {
	@Autowired
	private UserService userService;

	/**
	 * Web service for getting all the appUsers in the application.
	 * 
	 * @return list of all AppUser
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/userss", method = RequestMethod.GET)
	public List<UsersDto> users() {
		return userService.getlistuser();
	}

	/**
	 * Web service for getting a user by his ID
	 * 
	 * @param id
	 *            appUser ID
	 * @return appUser
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsersDto> userById(@PathVariable String id) {
		UsersDto appUser = userService.getinfouser(id);
		if (appUser == null) {
			return new ResponseEntity<UsersDto>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<UsersDto>(appUser, HttpStatus.OK);
		}
	}

	/**
	 * Method for deleting a user by his ID
	 * 
	 * @param id
	 * @return
	 */
//	@PreAuthorize("hasRole('USER')")
//	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<UsersDto> deleteUser(@PathVariable Long id) {
//		UsersDto appUser = userService.getinfouser(id);
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String loggedUsername = auth.getName();
//		if (appUser == null) {
//			return new ResponseEntity<UsersDto>(HttpStatus.NO_CONTENT);
//		} else if (appUser.getUser_name().equalsIgnoreCase(loggedUsername)) {
//			throw new RuntimeException("You cannot delete your account");
//		} else {
////			userService.delete(appUser);
//			return new ResponseEntity<UsersDto>(appUser, HttpStatus.OK);
//		}
//
//	}
//
//	/**
//	 * Method for adding a appUser
//	 *
//	 * @param appUser
//	 * @return
//	 */
//	@PreAuthorize("hasRole('USER')")
//	@RequestMapping(value = "/users", method = RequestMethod.POST)
//	public ResponseEntity<AppUser> createUser(@RequestBody AppUser appUser) {
//		if (appUserRepository.findOneByUsername(appUser.getUsername()) != null) {
//			throw new RuntimeException("Username already exist");
//		}
//		return new ResponseEntity<AppUser>(appUserRepository.save(appUser), HttpStatus.CREATED);
//	}
//
//	/**
//	 * Method for editing an user details
//	 *
//	 * @param appUser
//	 * @return modified appUser
//	 */
//	@PreAuthorize("hasRole('USERS')")
//	@RequestMapping(value = "/users", method = RequestMethod.PUT)
//	public AppUser updateUser(@RequestBody AppUser appUser) {
//		if (appUserRepository.findOneByUsername(appUser.getUsername()) != null
//				&& appUserRepository.findOneByUsername(appUser.getUsername()).getId() != appUser.getId()) {
//			throw new RuntimeException("Username already exist");
//		}
//		return appUserRepository.save(appUser);
//	}

}
