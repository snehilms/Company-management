package com.company.springboot.services;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.company.springboot.model.Company;
import com.company.springboot.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CompanyService.class})
@ExtendWith(SpringExtension.class)
public class CompanyServiceTest {
    @MockBean
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyService companyService;

    @Test
    public void testGetCompanyByName() {
        Company company = new Company();
        company.setId(1);
        company.setCompName("Comp Name");
        company.setCompAddr("42 Main St");
        company.setCompCeo("Comp Ceo");
        company.setDate("2020-03-01");
        when(this.companyRepository.findByName(anyString())).thenReturn(company);
        assertSame(company, this.companyService.getCompanyByName("Name"));
        verify(this.companyRepository).findByName(anyString());
    }

    @Test
    public void testConstructor() {
        assertNull((new CompanyService()).getCompanies());
    }
}

