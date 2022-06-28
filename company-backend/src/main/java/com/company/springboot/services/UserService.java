package com.company.springboot.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.springboot.model.Role;
import com.company.springboot.model.User;
import com.company.springboot.repository.RoleRepository;
import com.company.springboot.repository.UserRepository;
@Service
@Transactional
public class UserService implements IUserService, UserDetailsService{
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public User saveUser(User user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		User user = userRepository.findByUsername(username);
		Role role = roleRepository.findByName(roleName);
		user.getRoles().add(role);
		
	}

	@Override
	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
		}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("User not ound in the database");
		}
		Collection<SimpleGrantedAuthority> auth = new ArrayList<>();
		user.getRoles().forEach(role->{
			auth.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),auth);
	}


}
