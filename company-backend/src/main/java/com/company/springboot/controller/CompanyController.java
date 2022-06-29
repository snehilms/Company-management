/**
 * 
 */
package com.company.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.springboot.model.Company;
import com.company.springboot.repository.CompanyRepository;
import com.company.springboot.services.ICompanyService;

/**
 * @author snehil
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	ICompanyService companyService;
	
	@GetMapping("/get_companies")
	public List<Company> getCompanies()
	{
		return companyRepository.findAll();
	}
	@RequestMapping(value="/create_company",method = RequestMethod.POST)
	public Company createCompany(@RequestBody Company newcompany)
	{
		return companyRepository.save(newcompany);
	}
	
	@GetMapping("/get_company_id/{id}")
	public Optional<Company> getCompanyById(@PathVariable Integer id)
	{
//		Company comp = companyrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id : "+id));
//		return ResponseEntity.ok(comp);
		return companyRepository.findById(id);
	}
	
	@GetMapping("/get_company_name/{comp_name}")
	public Company getCompanyByName(@PathVariable String comp_name)
	{
		return companyService.getCompanyByName(comp_name);
		
	}
	
	

}
