let board = {
	init: function(){
		$("#btn-save").bind("click", () => {
			this.save();
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
	}
}

board.init();
