package com.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.entities.Company;
import com.demo.repositories.CompanyRepository;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Company findById(Integer companyId) {
		return companyRepository.findById(companyId).get();
	}

	@Override
	public Company findByCompanyName(String companyName) {
		return companyRepository.findByCompanyName(companyName);
	}

	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	@Override
	public void save(Company company) {
		companyRepository.save(company);
	}

	@Override
	public Company findByCode(String code) {
		return companyRepository.findByCode(code);
	}

	@Override
	public Company findByEmail(String email) {
		return companyRepository.findByEmail(email);
	}
}