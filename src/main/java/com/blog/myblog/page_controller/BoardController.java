package com.blog.myblog.page_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.blog.myblog.model.Board;
import com.blog.myblog.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	// 나의 블로그 화면
	@GetMapping("/board/index")
	public String boardIndex(@PageableDefault(size = 5, sort = "id", direction = Direction.DESC) Pageable pageable
			, Model model) {
		Page<Board> boards = boardService.getBoardList(pageable);
		
		model.addAttribute("boards", boards);
		return "board/board_index";
	}
	
	// 글 작성 화면
	@GetMapping("/board/write_form")
	public String writeBoard() {
		return "board/board_write_form";
	}
	
	// 글 상세보기 
	@GetMapping("/board/{id}")
	public String detailBoard(@PathVariable int id, Model model) {
		Board board = boardService.detailBoard(id);
		model.addAttribute("board", board);
		return "board/detail";
	}

}
