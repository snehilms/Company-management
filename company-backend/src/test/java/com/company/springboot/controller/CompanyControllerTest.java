package com.company.springboot.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import com.company.springboot.model.Company;
import com.company.springboot.repository.CompanyRepository;
import com.company.springboot.services.ICompanyService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CompanyController.class})
@ExtendWith(SpringExtension.class)
public class CompanyControllerTest {
    @Autowired
    private CompanyController companyController;

    @MockBean
    private CompanyRepository companyRepository;

    @MockBean
    private ICompanyService iCompanyService;

    @Test
    public void testCreateCompany() throws Exception {
        Company company = new Company();
        company.setId(1);
        company.setCompName("Comp Name");
        company.setCompAddr("42 Main St");
        company.setCompCeo("Comp Ceo");
        company.setDate("2020-03-01");
        when(this.companyRepository.save((Company) any())).thenReturn(company);

        Company company1 = new Company();
        company1.setId(1);
        company1.setCompName("Comp Name");
        company1.setCompAddr("42 Main St");
        company1.setCompCeo("Comp Ceo");
        company1.setDate("2020-03-01");
        String content = (new ObjectMapper()).writeValueAsString(company1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/company/create_company")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.companyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"compName\":\"Comp Name\",\"compCeo\":\"Comp Ceo\",\"compAddr\":\"42 Main St\",\"date\":\"2020-03-01\"}"));
    }

    @Test
    public void testGetCompanyByName() throws Exception {
        Company company = new Company();
        company.setId(1);
        company.setCompName("Comp Name");
        company.setCompAddr("42 Main St");
        company.setCompCeo("Comp Ceo");
        company.setDate("2020-03-01");
        Optional<Company> ofResult = Optional.<Company>of(company);
        when(this.iCompanyService.getCompanyByName(anyString())).thenReturn(ofResult);
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.get("/company/get_company_name/*")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new String()));
        MockMvcBuilders.standaloneSetup(this.companyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"compName\":\"Comp Name\",\"compCeo\":\"Comp Ceo\",\"compAddr\":\"42 Main St\",\"date\":\"2020-03-01\"}"));
    }

    @Test
    public void testGetCompanies() throws Exception {
        when(this.companyRepository.findAll()).thenReturn(new ArrayList<Company>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/company/get_companies");
        MockMvcBuilders.standaloneSetup(this.companyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    public void testGetCompanies2() throws Exception {
        when(this.companyRepository.findAll()).thenReturn(new ArrayList<Company>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/company/get_companies");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.companyController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    public void testGetCompanyById() throws Exception {
        Company company = new Company();
        company.setId(1);
        company.setCompName("Comp Name");
        company.setCompAddr("42 Main St");
        company.setCompCeo("Comp Ceo");
        company.setDate("2020-03-01");
        Optional<Company> ofResult = Optional.<Company>of(company);
        when(this.companyRepository.findById((Integer) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/company/get_company_id/{id}", 1);
        MockMvcBuilders.standaloneSetup(this.companyController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"compName\":\"Comp Name\",\"compCeo\":\"Comp Ceo\",\"compAddr\":\"42 Main St\",\"date\":\"2020-03-01\"}"));
    }
}

