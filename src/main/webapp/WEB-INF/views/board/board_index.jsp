<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<c:forEach var="board" items="${boards.content}">
		<div class="card text-center">
		  <div class="card-body">
		    <h4 class="card-title" id="title" >${board.title}</h4>
		    <a href="/board/${board.id}" class="card-link text-secondary">더보기</a>
		  </div>
		</div>
		<br/>
	</c:forEach>
</div>

</body>
</html>