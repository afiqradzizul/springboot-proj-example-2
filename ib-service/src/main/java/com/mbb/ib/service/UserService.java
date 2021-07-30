package com.mbb.ib.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mbb.ib.entity.Users;
import com.mbb.ib.repository.IUserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = userRepo.findByUsername(username);

		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}
}
