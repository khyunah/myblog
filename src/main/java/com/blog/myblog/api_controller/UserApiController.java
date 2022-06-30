package com.blog.myblog.api_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.myblog.dto.ResponseDto;
import com.blog.myblog.model.User;
import com.blog.myblog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationManager authenticationManager;

	// 회원가입 
	@PostMapping("/auth/user/join")
	public ResponseDto<User> joinUser(@RequestBody User user) {
		return new ResponseDto<>(HttpStatus.OK.value(), userService.joinUser(user));  
	}
	
	// 회원정보 수정
	@PutMapping("/user/update-info")
	public ResponseDto<Integer> updateUser(@RequestBody User user){
		userService.updateUser(user);
		System.out.println("zzz");
		// 세션 정보 바꿔주기
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new ResponseDto<>(HttpStatus.OK.value(), 1);
	}
	
}
