<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form class="m-5" action="/auth/user/login" method="post">
		<div class="form-group">
		  <label for="username">아이디:</label>
		  <input type="text" class="form-control" placeholder="Enter username" name="username" id="username">
		</div>
		<div class="form-group">
		  <label for="password">패스워드:</label>
		  <input type="password" class="form-control" placeholder="Enter password" name="password" id="password">
		</div>
		<button type="submit" class="btn btn-secondary">로그인</button>
	</form>	
</div>
</body>
</html>