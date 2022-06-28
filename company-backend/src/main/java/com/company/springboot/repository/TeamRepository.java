package com.company.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.company.springboot.dto.ITeamDTO;
import com.company.springboot.model.Team;


@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{

	@Query(value="select c.company_name as Companies,group_concat(t.team_lead) as leadName from company c join Team t on c.id=t.comp_id group by c.company_name", nativeQuery = true)
	List<ITeamDTO> getTeamList();
}
