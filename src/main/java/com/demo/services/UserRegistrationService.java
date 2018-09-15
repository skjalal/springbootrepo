package com.demo.services;

import java.util.List;

import com.demo.entities.UserRegistration;

public interface UserRegistrationService {

	public UserRegistration findById(Integer id);

	public UserRegistration findByUserName(String userName);

	public List<UserRegistration> findAll();

	public void save(UserRegistration userRegistration);
}