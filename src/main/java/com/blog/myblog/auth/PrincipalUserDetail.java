package com.blog.myblog.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.blog.myblog.model.User;

public class PrincipalUserDetail implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 컴포지션 관계로 만들어 줘야 한다.
	private User user;
	
	public PrincipalUserDetail(User user) {
		this.user = user;
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	// 계정이 만료
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정 잠김
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 비밀번호 만료
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 휴먼 계정
	@Override
	public boolean isEnabled() {
		return true;
	}

	// 사용자의 권한을 알아야 한다.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collentors = new ArrayList<>();
		collentors.add(() -> {
			return "ROLL_" + user.getRole();
		});
		return collentors;
	}

}
