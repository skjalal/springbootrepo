package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.UserRegistration;

@Service("loggedInUser")
public class LoggedInUser implements ILoggedInUser {

	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@Override
	public UserRegistration getLoggedInUser(String name) {
		return userRegistrationService.findByUserName(name);
	}
}