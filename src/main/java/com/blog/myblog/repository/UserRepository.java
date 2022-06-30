package com.blog.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.myblog.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
