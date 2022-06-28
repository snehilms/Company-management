package com.company.springboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.springboot.model.Role;
import com.company.springboot.model.User;
@Service
public interface IUserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username,String roleName);
	User getUser(String username);
	List<User> getUsers();
}
