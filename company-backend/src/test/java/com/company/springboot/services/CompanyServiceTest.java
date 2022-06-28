package com.company.springboot.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CompanyService.class})
@ExtendWith(SpringExtension.class)
public class CompanyServiceTest {
    @Autowired
    private CompanyService companyService;

    @Test
    public void testGetCompanyByName() {
        assertFalse(this.companyService.getCompanyByName("Name").isPresent());
    }

    @Test
    public void testConstructor() {
        assertNull((new CompanyService()).getCompanies());
    }
}

