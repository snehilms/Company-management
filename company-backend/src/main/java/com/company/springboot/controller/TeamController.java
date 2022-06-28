package com.company.springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.springboot.model.Team;
import com.company.springboot.services.ITeamService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@CrossOrigin
@RequestMapping("/team")
public class TeamController {
	
	
	@Autowired
	ITeamService teamService;
	
	@RequestMapping(value="/create_team/{comp_id}",method = RequestMethod.POST)
	public Team createTeam(@RequestBody JsonNode newTeam,@PathVariable int comp_id)
	{
		return teamService.createTeam(newTeam,comp_id);
	}
	
	@GetMapping(value="/get_teams")
	public Map<String,JsonNode> getTeams()
	{
		return teamService.getTeams();
	}
}
