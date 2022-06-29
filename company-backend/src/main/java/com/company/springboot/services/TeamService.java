package com.company.springboot.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.springboot.dto.ITeamDTO;
import com.company.springboot.model.Company;
import com.company.springboot.model.Team;
import com.company.springboot.repository.CompanyRepository;
import com.company.springboot.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TeamService implements ITeamService{
	
	@Autowired
	TeamRepository teamrepository;
	@Autowired
	CompanyRepository compRepo;
	
	@Override
	public Team createTeam(JsonNode newTeam, int comp_id) {
		
		JsonNode leadName = newTeam.get("leadName");
		Company registered_company= compRepo.getById(comp_id);
		Team createdTeam = new Team(leadName.textValue(),registered_company);
		teamrepository.save(createdTeam);
		return createdTeam;
	}

	@Override
	public Map<String,JsonNode> getTeams() {
		List<ITeamDTO> teamList= teamrepository.getTeamList();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode teamData= mapper.valueToTree(teamList);
		Map<String,JsonNode> companyTeamList=  new HashMap<>();
		for(JsonNode data:teamData)
		{
			String company = data.get("companies").textValue();
			JsonNode leadName = data.get("leadName");
			companyTeamList.put(company, leadName);		
		}
		return companyTeamList;
	}

}
