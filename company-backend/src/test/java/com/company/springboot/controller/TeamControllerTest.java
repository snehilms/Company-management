package com.company.springboot.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.company.springboot.model.Company;
import com.company.springboot.model.Team;
import com.company.springboot.services.ITeamService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.DoubleNode;

import java.util.HashMap;

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

@ContextConfiguration(classes = {TeamController.class})
@ExtendWith(SpringExtension.class)
public class TeamControllerTest {
    @MockBean
    private ITeamService iTeamService;

    @Autowired
    private TeamController teamController;

    @Test
    public void testCreateTeam() throws Exception {
        Company company = new Company();
        company.setId(1);
        company.setCompName("Comp Name");
        company.setCompAddr("42 Main St");
        company.setCompCeo("Comp Ceo");
        company.setDate("2020-03-01");

        Team team = new Team();
        team.setLeadName("Lead Name");
        team.setId(1);
        team.setCompId(company);
        when(this.iTeamService.createTeam((com.fasterxml.jackson.databind.JsonNode) any(), anyInt())).thenReturn(team);
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/team/create_team/{comp_id}", 1)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(DoubleNode.valueOf(10.0)));
        MockMvcBuilders.standaloneSetup(this.teamController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"leadName\":\"Lead Name\",\"compId\":{\"id\":1,\"compName\":\"Comp Name\",\"compCeo\":\"Comp Ceo\",\"compAddr\":\"42"
                                        + " Main St\",\"date\":\"2020-03-01\"}}"));
    }

    @Test
    public void testGetTeams() throws Exception {
        when(this.iTeamService.getTeams()).thenReturn(new HashMap<String, JsonNode>(1));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/team/get_teams");
        MockMvcBuilders.standaloneSetup(this.teamController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

    @Test
    public void testGetTeams2() throws Exception {
        when(this.iTeamService.getTeams()).thenReturn(new HashMap<String, JsonNode>(1));
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/team/get_teams");
        postResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.teamController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }
}

