package com.blog.myblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.myblog.model.User;
import com.blog.myblog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User joinUser(User user) {
		// 비밀번호 해싱해야 한다. 
		User userEntity = userRepository.save(user);
		return userEntity;
	}
}
