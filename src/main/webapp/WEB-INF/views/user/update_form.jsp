<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form class="m-5">
		<input type="hidden" id="id" value="${principal.user.id}">
		<div class="form-group">
		  <label for="username">아이디:</label>
		  <input type="text" class="form-control" value="${principal.user.username}"id="username" readonly="readonly">
		</div>
		<div class="form-group">
		  <label for="password">패스워드:</label>
		  <input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<div class="form-group">
		  <label for="email">이메일:</label>
		  <input type="email" class="form-control" value="${principal.user.email}" id="email">
		</div>
		<button id="btn-update" type="button" class="btn btn-secondary">수정하기</button>
	</form>	
</div>

<script src="/js/user.js"></script>

</body>
</html>