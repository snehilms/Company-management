package com.company.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="team")
public class Team implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "team_lead", length = 500, nullable = true)
	private String leadName;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "comp_id", referencedColumnName="id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Company compId;
	
	

	public Team(String leadName, Company compId) {
		super();
		this.leadName = leadName;
		this.compId = compId;
	}



	public Team() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the leadName
	 */
	public String getLeadName() {
		return leadName;
	}



	/**
	 * @param leadName the leadName to set
	 */
	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}



	/**
	 * @return the compId
	 */
	public Company getCompId() {
		return compId;
	}



	/**
	 * @param compId the compId to set
	 */
	public void setCompId(Company compId) {
		this.compId = compId;
	}






}
