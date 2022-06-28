package com.company.springboot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CompanyTest {
    @Test
    public void testConstructor() {
        Company actualCompany = new Company();
        actualCompany.setCompAddr("42 Main St");
        actualCompany.setCompCeo("Comp Ceo");
        actualCompany.setCompName("Comp Name");
        actualCompany.setDate("2020-03-01");
        actualCompany.setId(1);
        assertEquals("42 Main St", actualCompany.getCompAddr());
        assertEquals("Comp Ceo", actualCompany.getCompCeo());
        assertEquals("Comp Name", actualCompany.getCompName());
        assertEquals("2020-03-01", actualCompany.getDate());
        assertEquals(1, actualCompany.getId());
    }

    @Test
    public void testConstructor2() {
        Company actualCompany = new Company("Comp Name", "Comp Ceo", "42 Main St", "2020-03-01");
        actualCompany.setCompAddr("42 Main St");
        actualCompany.setCompCeo("Comp Ceo");
        actualCompany.setCompName("Comp Name");
        actualCompany.setDate("2020-03-01");
        actualCompany.setId(1);
        assertEquals("42 Main St", actualCompany.getCompAddr());
        assertEquals("Comp Ceo", actualCompany.getCompCeo());
        assertEquals("Comp Name", actualCompany.getCompName());
        assertEquals("2020-03-01", actualCompany.getDate());
        assertEquals(1, actualCompany.getId());
    }
}

