package com.company.springboot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class TeamTest {
    @Test
    public void testConstructor() {
        Team actualTeam = new Team();
        Company company = new Company();
        company.setId(1);
        company.setCompName("Comp Name");
        company.setCompAddr("42 Main St");
        company.setCompCeo("Comp Ceo");
        company.setDate("2020-03-01");
        actualTeam.setCompId(company);
        actualTeam.setId(1);
        actualTeam.setLeadName("Lead Name");
        assertSame(company, actualTeam.getCompId());
        assertEquals(1, actualTeam.getId());
        assertEquals("Lead Name", actualTeam.getLeadName());
    }

    @Test
    public void testConstructor2() {
        Team actualTeam = new Team("Lead Name", new Company("Comp Name", "Comp Ceo", "42 Main St", "2020-03-01"));
        Company company = new Company();
        company.setId(1);
        company.setCompName("Comp Name");
        company.setCompAddr("42 Main St");
        company.setCompCeo("Comp Ceo");
        company.setDate("2020-03-01");
        actualTeam.setCompId(company);
        actualTeam.setId(1);
        actualTeam.setLeadName("Lead Name");
        assertSame(company, actualTeam.getCompId());
        assertEquals(1, actualTeam.getId());
        assertEquals("Lead Name", actualTeam.getLeadName());
    }
}

