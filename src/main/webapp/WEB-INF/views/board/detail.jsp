<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<button id="btn-delete" type="button" class="btn btn-secondary float-right m-1">삭제</button>
	<a href="/board/update_form/${board.id}" type="button" class="btn btn-secondary float-right m-1">수정</a>
	<br/><br/><br/>
</div>
<div class="container">
	<div class="text-center">
		<h3>${board.title}</h3>
	</div>
	<br/><hr/>
	<div class="text-center">
		<p>${board.content}</p>
	</div>
</div>
</body>
</html>