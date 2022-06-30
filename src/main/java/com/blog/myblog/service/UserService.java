package com.blog.myblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.myblog.model.RollType;
import com.blog.myblog.model.User;
import com.blog.myblog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public User joinUser(User user) {
		String encpdingPassword = encoder.encode(user.getPassword());
		user.setPassword(encpdingPassword);
		user.setRole(RollType.USER);
		User userEntity = userRepository.save(user);
		return userEntity;
	}
}
