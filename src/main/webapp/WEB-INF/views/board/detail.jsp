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
			<li class="list-group-item d-flex justify-content-between" id="reply-1">
				<div>${reply.content}</div>
				<div class="d-flex">
					<div>작성자 : ${reply.user.username}&nbsp;&nbsp;</div>
					<button type="button" class="btn btn-sm btn-outline-secondary">삭제</button>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>
</body>
</html>
