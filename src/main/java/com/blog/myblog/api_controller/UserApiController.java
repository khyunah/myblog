package com.blog.myblog.api_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.myblog.dto.ResponseDto;
import com.blog.myblog.model.User;
import com.blog.myblog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;

	// 회원가입 
	@PostMapping("/auth/user/join")
	public ResponseDto<User> joinUser(@RequestBody User user) {
		return new ResponseDto<>(HttpStatus.OK.value(), userService.joinUser(user));  
	}
}
