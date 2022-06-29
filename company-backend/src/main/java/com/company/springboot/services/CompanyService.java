package com.company.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.springboot.model.Company;
import com.company.springboot.repository.CompanyRepository;

@Service
public class CompanyService implements ICompanyService{
	
	@Autowired
	CompanyRepository compRepo;
	
	@Override
	public List<Company> getCompanies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company getCompanyByName(String name) {
		Company company =  compRepo.findByName(name);
		return company;
	}

	

}
