package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.UserRegistration;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Integer> {
	public UserRegistration findByUserName(String userName);
}