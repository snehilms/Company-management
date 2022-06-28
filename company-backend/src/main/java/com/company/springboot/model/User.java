package com.company.springboot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name = "id", unique = true, nullable = false)
private int id;

@Column(name = "username")
private String username;

@Column(name = "password")
private String password;

@ManyToMany(fetch=FetchType.EAGER)
private Collection<Role> roles= new ArrayList<>();


public User() {
	super();
	// TODO Auto-generated constructor stub
}

public User(String username, String password, Collection<Role> roles) {
	super();
	this.username = username;
	this.password = password;
	this.roles = roles;
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
 * @return the username
 */
public String getUsername() {
	return username;
}

/**
 * @param username the username to set
 */
public void setUsername(String username) {
	this.username = username;
}

/**
 * @return the password
 */
public String getPassword() {
	return password;
}

/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}

/**
 * @return the roles
 */
public Collection<Role> getRoles() {
	return roles;
}

/**
 * @param roles the roles to set
 */
public void setRoles(Collection<Role> roles) {
	this.roles = roles;
}


}
