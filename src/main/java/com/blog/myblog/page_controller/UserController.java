package com.blog.myblog.page_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	// 회원가입 화면 
	@GetMapping("/auth/join_form")
	public String joinForm() {
		return "user/join_form";
	}
}
