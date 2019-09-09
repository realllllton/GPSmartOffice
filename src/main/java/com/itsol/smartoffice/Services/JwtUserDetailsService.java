package com.itsol.smartoffice.Services;

import java.io.IOException;
import java.util.*;

import com.itsol.smartoffice.Services.User.UserService;
import com.itsol.smartoffice.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersDto usersDto = userService.getinfouser(username);
		if (usersDto == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		String encodedPassword = bcryptEncoder.encode(usersDto.getPass_word());
		GrantedAuthority authority = new SimpleGrantedAuthority(usersDto.getName_role());
		return new User(usersDto.getUser_name(), encodedPassword, Arrays.asList(authority));
	}
	public UsersDto loadUserDtoByUsername(String username){
        UsersDto usersDto = userService.getinfouser(username);
        if (usersDto == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        String encodedPassword = bcryptEncoder.encode(usersDto.getPass_word());
        usersDto.setPass_word(encodedPassword);
        return usersDto;
    }

//	public DAOUser save(User user) {
//		DAOUser newUser = new DAOUser();
//		newUser.setUsername(user.getUsername());
//		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//		return userDao.save(newUser);
//	}
}
