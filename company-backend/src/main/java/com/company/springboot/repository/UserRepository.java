package com.company.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
