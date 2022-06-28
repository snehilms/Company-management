package com.company.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.company.springboot.model.Company;

@Service
public class CompanyService implements ICompanyService{

	@Override
	public List<Company> getCompanies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Company> getCompanyByName(String name) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	

}
