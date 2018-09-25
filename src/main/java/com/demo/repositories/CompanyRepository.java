package com.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	public Company findByCompanyName(String companyName);
	
	public Company findByCode(String code);
	
	public Company findByEmail(String email);

	public Page<Company> findByCompanyNameIgnoreCaseContaining(Pageable pageable, String search);
	
}