package com.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.CompanyDetails;

public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Integer> {
	
	public Page<CompanyDetails> findByCompanyNameIgnoreCaseContaining(Pageable pageable, String search);
}