package com.company.springboot.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.company.springboot.dto.ITeamDTO;
import com.company.springboot.repository.CompanyRepository;
import com.company.springboot.repository.TeamRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TeamService.class})
@ExtendWith(SpringExtension.class)
public class TeamServiceTest {
    @MockBean
    private CompanyRepository companyRepository;

    @MockBean
    private TeamRepository teamRepository;

    @Autowired
    private TeamService teamService;

    @Test
    public void testGetTeams() {
        when(this.teamRepository.getTeamList()).thenReturn(new ArrayList<ITeamDTO>());
        assertTrue(this.teamService.getTeams().isEmpty());
        verify(this.teamRepository).getTeamList();
    }
}

