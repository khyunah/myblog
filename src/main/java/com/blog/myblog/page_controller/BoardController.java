package com.blog.myblog.page_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	// 로그인 하지 않은 홈 화면
	@GetMapping({"/", ""})
	public String index() {
		return "index";
	}

}
