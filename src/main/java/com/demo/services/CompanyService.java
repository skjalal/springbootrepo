package com.demo.services;

import java.util.List;

import com.demo.entities.Company;

public interface CompanyService {
	
	public Company findById(Integer companyId);
	
	public Company findByCompanyName(String companyName);
	
	public Company findByCode(String code);
	
	public Company findByEmail(String email);
	
	public List<Company> findAll();
	
	public void save(Company company);
}