package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	public Role findByRole(String role);
}