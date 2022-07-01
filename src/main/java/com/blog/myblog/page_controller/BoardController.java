package com.blog.myblog.page_controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.myblog.dto.ResponseDto;
import com.blog.myblog.model.Board;
import com.blog.myblog.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	// 나의 블로그 화면
	@GetMapping({"/board/index", "/board/search"})
	public String boardIndex(String q, @PageableDefault(size = 5, sort = "id", direction = Direction.DESC) Pageable pageable
			, Model model) {
		
		String title = q == null ? "" : q;
		Page<Board> boards = boardService.searchBoardByTitle(title, pageable);
		
		int nowPage = boards.getNumber() + 1;
		int startPage = Math.max(nowPage - 2, 1);
		int endPage = Math.min(nowPage + 2, boards.getTotalPages());
		
		ArrayList<Integer> pages = new ArrayList<>();
		for (int i = startPage; i <= endPage; i++) {
			pages.add(i);
		}
		
		model.addAttribute("boards", boards.getContent());
		model.addAttribute("pages", pages);
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
	
	// 글 수정 화면
	@GetMapping("/board/update_form/{id}")
	public String updateBoard(@PathVariable int id, Model model){
		Board board = boardService.detailBoard(id);
		model.addAttribute("board", board);
		return "board/board_update_form";
	}

}
