package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	public Company findByCompanyName(String companyName);
	
	public Company findByCode(String code);
	
	public Company findByEmail(String email);
	
}