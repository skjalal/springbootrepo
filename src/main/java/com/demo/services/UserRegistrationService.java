package com.demo.services;

import java.util.List;

import com.demo.entities.UserRegistration;

public interface UserRegistrationService {

	public UserRegistration findById(Integer id);

	public UserRegistration findByEmail(String email);

	public List<UserRegistration> findAll();

	public void save(UserRegistration userRegistration);
}