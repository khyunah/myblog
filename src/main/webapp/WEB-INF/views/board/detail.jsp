<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<button id="btn-delete" type="button" class="btn btn-secondary float-right m-1">삭제</button>
	<button id="btn-update" type="button" class="btn btn-secondary float-right m-1">수정</button>
	<br/><br/><br/>
</div>
<div class="container">
	<input type="hidden" id="boardId" value="${board.id}">
	<div class="text-center">
		<h3>${board.title}</h3>
	</div>
	<br/><hr/>
	<div class="text-center">
		<p>${board.content}</p>
	</div>
</div>
<script src="/js/board.js"></script>
</body>
</html>