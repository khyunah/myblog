package com.blog.myblog.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.myblog.model.User;
import com.blog.myblog.repository.UserRepository;

@Service
public class PrincipalUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).orElseThrow(() -> {
			return new IllegalArgumentException("가입되어 있는 아이디가 아닙니다.");
		});
		return new PrincipalUserDetail(user);
	}

}
