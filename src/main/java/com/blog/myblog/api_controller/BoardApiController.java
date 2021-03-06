package com.blog.myblog.api_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.myblog.auth.PrincipalUserDetail;
import com.blog.myblog.dto.ResponseDto;
import com.blog.myblog.model.Board;
import com.blog.myblog.model.Reply;
import com.blog.myblog.service.BoardService;

@RestController
public class BoardApiController {
	
	@Autowired
	private BoardService boardService;

	// 글 저장하기 
	@PostMapping("/board/save")
	public ResponseDto<Board> saveBoard(@RequestBody Board board, @AuthenticationPrincipal PrincipalUserDetail detail) {
		Board boardEntity = boardService.saveBoard(board, detail.getUser());
		return new ResponseDto<Board>(HttpStatus.OK.value(), boardEntity);
	}
	
	// 글 삭제하기
	@DeleteMapping("/board/delete/{id}")
	public ResponseDto<Integer> deleteBoard(@PathVariable int id){
		boardService.deleteBoardById(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	// 글 수정하기
	@PutMapping("/board/update")
	public ResponseDto<Board> updateBoard(@RequestBody Board board){
		Board boardEntity = boardService.updateBoard(board);
		return new ResponseDto<Board>(HttpStatus.OK.value(), boardEntity);
	}
	
	// 댓글 등록
	@PostMapping("/board-reply/{boardId}/save")
	public ResponseDto<Reply> saveReply(@PathVariable int boardId, @RequestBody Reply reply, 
			@AuthenticationPrincipal PrincipalUserDetail detail){
		return new ResponseDto<>(HttpStatus.OK.value(), boardService.saveReply(boardId, reply, detail.getUser()));
	}
	
	// 댓글 삭제
	@DeleteMapping("/board-reply/delete/{replyId}")
	public ResponseDto<Integer> deleteReply(@PathVariable int replyId){
		boardService.deleteReplyById(replyId);
		return new ResponseDto<>(HttpStatus.OK.value(), 1);
	}

}
