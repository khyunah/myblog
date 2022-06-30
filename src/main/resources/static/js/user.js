let user = {
	init: function(){
		$("#btn-join").bind("click", () => {
			this.join();
		});
		
		$("#btn-update").bind("click", () => {
			this.update();
		});
	},
	
	join: function(){
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		
		$.ajax({
			type: "POST",
			url: "/auth/user/join",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(){
			alert("회원가입이 완료되었습니다.");
			location.href = "/";
		}).fail(function(){
			alert("회원가입이 정상 처리되지 않았습니다.");
		});
	},
	
	update: function(){
		let data = {
			id: $("#id").val(),
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		
		$.ajax({
			type: "PUT",
			url: "/user/update-info",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(){
			alert("회원 정보수정이 완료되었습니다.");
			location.href = "/"
		}).fail(function(){
			alert("회원 정보수정 실패");
		});
	},
	
	logout: function(){
		if(confirm("로그아웃 하시겠습니까?")){
			location.href = "/logout";
		}
	}
}

user.init();
