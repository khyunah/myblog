package com.blog.myblog.page_controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.blog.myblog.dto.KakaoProfile;
import com.blog.myblog.dto.OAuthToken;
import com.blog.myblog.dto.ResponseDto;

@Controller
public class UserController {
	
	// 회원가입 화면 
	@GetMapping("/auth/join_form")
	public String joinForm() {
		return "user/join_form";
	}
	
	// 로그인 화면 
	@GetMapping("/auth/login_form")
	public String loginForm() {
		return "user/login_form";
	}
	
	// 내 정보 화면 
	@GetMapping("/user/my-info")
	public String userInfo() {
		return "user/update_form";
	}
	
	// 카카오 로그인 
	@GetMapping("/auth/kakao/callback")
	@ResponseBody
	public String kakaoCallback(String code) {	// 1. 인가 코드 받기
		
		// 2. 토큰 받기
		HttpHeaders tokenHeaders = new HttpHeaders();
		tokenHeaders.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		MultiValueMap<String, String> tokenParams = new LinkedMultiValueMap<>();
		tokenParams.add("grant_type", "authorization_code");
		tokenParams.add("client_id", "0d6bcf296d67c35ad944b2a3d38df9be");
		tokenParams.add("redirect_uri", "http://localhost:9090/auth/kakao/callback");
		tokenParams.add("code", code);
		
		HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<MultiValueMap<String,String>>(tokenParams, tokenHeaders);
		RestTemplate tokenPost = new RestTemplate();
		ResponseEntity<OAuthToken> tokenResponse = tokenPost.exchange(
				"https://kauth.kakao.com/oauth/token",
				HttpMethod.POST,
				tokenRequest,
				OAuthToken.class);
		
		// 3. 사용자 정보 가져 오기
		HttpHeaders kakaoUserInfoHeaders = new HttpHeaders();
		kakaoUserInfoHeaders.add("Authorization", "Bearer " + tokenResponse.getBody().getAccessToken());
		kakaoUserInfoHeaders.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		HttpEntity<MultiValueMap<String, String>> kakaoUserInfoRequest = new HttpEntity<>(kakaoUserInfoHeaders); 
		RestTemplate kakaoUserInfoPost = new RestTemplate();
		ResponseEntity<KakaoProfile> kakaoUserInfoResponse = kakaoUserInfoPost.exchange(
				"https://kapi.kakao.com/v2/user/me",
				HttpMethod.POST,
				kakaoUserInfoRequest,
				KakaoProfile.class);
		
		return "사용자 정보 : " + kakaoUserInfoResponse;
	}
}
