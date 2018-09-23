package com.demo.services;

import com.demo.entities.UserRegistration;

public interface ILoggedInUser {
	
	public UserRegistration getLoggedInUser(String name);
}