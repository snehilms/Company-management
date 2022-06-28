package com.company.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.company.springboot.model.Company;
@Service
public interface ICompanyService {

	public List<Company> getCompanies();

	public Optional<Company> getCompanyByName(String comp_name);


}
