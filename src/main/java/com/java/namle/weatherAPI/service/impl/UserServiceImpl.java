package com.java.namle.weatherAPI.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.java.namle.weatherAPI.dao.UserRepository;
import com.java.namle.weatherAPI.modelEntity.User;
import com.java.namle.weatherAPI.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public User save(User user) {
		String rawPassword = user.getPassword();
		String encodedPassword = passwordEncoder.encode(rawPassword);
		user.setPassword(encodedPassword);
		
		return repository.save(user);
	}

}
