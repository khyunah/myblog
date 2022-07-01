package com.blog.myblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.myblog.model.Board;
import com.blog.myblog.model.User;
import com.blog.myblog.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	// 글 전체 가져오기
	@Transactional(readOnly = true)
	public Page<Board> getBoardList(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
	// 글 저장하기
	@Transactional
	public Board saveBoard(Board board, User user) {
		board.setCount(0);
		board.setUser(user);
		return boardRepository.save(board);
	}
}
