package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Role;
import com.demo.repositories.RoleRepository;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findById(Integer id) {
		return roleRepository.findById(id).get();
	}

	@Override
	public Role findByRole(String role) {
		return roleRepository.findByRole(role);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}
}