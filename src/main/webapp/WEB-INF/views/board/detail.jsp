<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<c:if test="${board.user.id eq principal.user.id}">
		<button id="btn-delete" type="button" class="btn btn-secondary float-right m-1">삭제</button>
		<a href="/board/update_form/${board.id}" type="button" class="btn btn-secondary float-right m-1">수정</a>
	</c:if>
	<br/><br/><br/>
</div>
<div class="container">
	<input type="hidden" id="userId" value="${principal.user.id}">
	<input type="hidden" id="boardId" value="${board.id}">
	<div class="text-center">
		<h3>${board.title}</h3>
	</div>
	<br/><hr/>
	<div class="text-center">
		<p>${board.content}</p>
	</div>
</div>
<br/><br/><br/><br/>

<!-- 댓글부분 -->
<div class="container">
	<div class="input-group mb-3">
	  <input id="reply-content" type="text" class="form-control" placeholder="댓글">
	  <div class="input-group-append">
	    <button id="btn-reply-save" class="btn btn-secondary" type="button">등록</button>
	  </div>
	</div>
</div>

<div class="container">
	<ul class="list-group" id="reply-list">
		<c:forEach items="${board.replys}" var="reply">
			<li class="list-group-item d-flex justify-content-between" id="reply-${reply.id}">
				<div>${reply.content}</div>
				<div class="d-flex">
					<div>작성자 : ${reply.user.username}&nbsp;&nbsp;</div>
					<c:if test="${reply.user.id eq principal.user.id}">
						<button id="btn-reply-delete" type="button" class="btn btn-sm btn-outline-secondary">삭제</button>
					</c:if>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>
<script src="/js/board.js"></script>
</body>
</html>
