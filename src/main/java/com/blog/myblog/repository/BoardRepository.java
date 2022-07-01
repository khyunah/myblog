package com.blog.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.myblog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
