package com.demo.services;

import java.util.List;

import com.demo.entities.Role;

public interface RoleService {

	public Role findById(Integer id);

	public Role findByRole(String role);

	public List<Role> findAll();

	public void save(Role role);
}