package com.demo.services;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.demo.entities.UserRegistration;

@Service
public class UserServiceDetails implements UserDetailsService {

	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		UserRegistration userRegistration = userRegistrationService.findByUserName(username);
		if(userRegistration != null) {			
			user = new User(userRegistration.getUserName(), userRegistration.getPassword(), Arrays.asList(new SimpleGrantedAuthority(userRegistration.getRole().getRole())));
		}
		return user;
	}
}