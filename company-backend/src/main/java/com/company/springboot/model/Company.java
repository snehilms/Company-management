package com.company.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="company")
public class Company implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name="company_name", length = 500, nullable = true)
	private String compName;
	
	@Column(name="company_ceo", length = 500, nullable = true)
	private String compCeo;
	
	@Column(name="company_addr", length = 4000, nullable = true)
	private String compAddr;
	
	@Column(name="inception_date", nullable = true)
	private String date;
	
	public Company() {
		// TODO Auto-generated constructor stub
		
	}

	public Company(String compName, String compCeo, String compAddr, String date) {
		super();
		this.compName = compName;
		this.compCeo = compCeo;
		this.compAddr = compAddr;
		this.date = date;
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
	 * @return the compName
	 */
	public String getCompName() {
		return compName;
	}

	/**
	 * @param compName the compName to set
	 */
	public void setCompName(String compName) {
		this.compName = compName;
	}

	/**
	 * @return the compCeo
	 */
	public String getCompCeo() {
		return compCeo;
	}

	/**
	 * @param compCeo the compCeo to set
	 */
	public void setCompCeo(String compCeo) {
		this.compCeo = compCeo;
	}

	/**
	 * @return the compAddr
	 */
	public String getCompAddr() {
		return compAddr;
	}

	/**
	 * @param compAddr the compAddr to set
	 */
	public void setCompAddr(String compAddr) {
		this.compAddr = compAddr;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	
	

	

}
