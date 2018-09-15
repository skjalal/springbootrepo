package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.UserRegistration;
import com.demo.repositories.UserRegistrationRepository;

@Service("userRegistrationService")
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	private UserRegistrationRepository userRegistrationRepository;
	
	@Override
	public UserRegistration findById(Integer id) {
		return userRegistrationRepository.findById(id).get();
	}

	@Override
	public UserRegistration findByEmail(String userName) {
		return userRegistrationRepository.findByUserName(userName);
	}

	@Override
	public List<UserRegistration> findAll() {
		return userRegistrationRepository.findAll();
	}

	@Override
	public void save(UserRegistration userRegistration) {
		userRegistrationRepository.save(userRegistration);
	}
}