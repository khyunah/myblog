let board = {
	init: function(){
		$("#btn-save").bind("click", () => {
			this.save();
		});
		
		$("#btn-delete").bind("click", () => {
			this.delete();
		});
		
		$("#btn-update").bind("click", () => {
			this.update();
		});
		
		$("#btn-reply-save").bind("click", () => {
			this.replySave();
		});

	},
	
	save: function(){
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		}
		
		$.ajax({
			type: "POST",
			url: "/board/save",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(){
			alert("게시글 저장 성공");
			location.href = "/board/index";
		}).fail(function(){
			alert("게시글 저장 오류");
		});
	},
	
	delete: function(){
		let boardId = $("#boardId").val()
		
		$.ajax({
			type: "DELETE",
			url: `/board/delete/${boardId}`,
			dataType: "json"
		}).done(function(){
			alert("게시글 삭제 성공");
			location.href = "/board/index";
		}).fail(function(){
			alert("게시글 삭제 실패");
		});
	},
	
	update: function(){
		let data = {
			id: $("#boardId").val(),
			title: $("#title").val(),
			content: $("#content").val()
		}
		
		$.ajax({
			type:"PUT",
			url: "/board/update",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(){
			alert("게시글 수정 성공");
			location.href = `/board/${data.id}`
		}).fail(function(){
			alert("게시글 수정 실패");
		});
	}, 
	
	replySave: function(){
		let data = {
			boardId: $("#boardId").val(),
			content: $("#reply-content").val()
		}

		$.ajax({
			type: "POST",
			url: `/board-reply/${data.boardId}/save`,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(response){
			alert("댓글 작성 완료");
			addReplyHtml(response.data);
		}).fail(function(){
			alert("댓글 작성 오류");
		});
	}
}

function addReplyHtml(reply){
	let replyHtml = `
			<li class="list-group-item d-flex justify-content-between" id="reply-${reply.id}">
				<div>${reply.content}</div>
				<div class="d-flex">
					<div>작성자 : ${reply.user.username}&nbsp;&nbsp;</div>
					<button type="button" class="btn btn-sm btn-outline-secondary">삭제</button>
				</div>
			</li>
	`
	$("#reply-list").prepend(replyHtml);
	$("#reply-content").val("");
}

board.init();
