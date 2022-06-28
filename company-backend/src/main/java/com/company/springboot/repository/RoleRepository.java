package com.company.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.springboot.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByName(String name);
}
