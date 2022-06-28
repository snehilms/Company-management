package com.company.springboot.services;

import java.util.Map;

import com.company.springboot.model.Team;
import com.fasterxml.jackson.databind.JsonNode;

public interface ITeamService {

	Team createTeam(JsonNode newTeam, int comp_id);

	Map<String,JsonNode> getTeams();

}
