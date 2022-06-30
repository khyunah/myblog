let user = {
	init: function(){
		$("#btn-join").bind("click", () => {
			this.join();
		})
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
	}
}