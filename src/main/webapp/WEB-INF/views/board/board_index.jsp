<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">

	<div class="d-flex m-2 justify-content-end">
		<form class="form-inline" action="/board/search" method="get">
		  <input type="text" class="form-control" name="q" value="" placeholder="검색">
		  <button type="submit" class="btn btn-secondary ml-2">검색</button>
		</form>
	</div>

	<c:forEach var="board" items="${boards}">
		<div class="card text-center">
		  <div class="card-body">
		    <h4 class="card-title" id="title" >${board.title}</h4>
		    <a href="/board/${board.id}" class="card-link text-secondary">더보기</a>
		  </div>
		</div>
		<br/>
	</c:forEach>
	
	<c:set var="isDisabled" value="disabled"></c:set> 
	<c:set var="isNotDisabled" value=""></c:set>
	
	<ul class="pagination justify-content-center">
		<li class="page-item ${board.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-secondary" href="/board/index?page=${board.number - 1}">이전</a>
		</li>
		
		<c:forEach var="pageNum" items="${pages}">
			<li class="page-item"><a class="page-link text-secondary" href="/board/index?page=${pageNum - 1}">${pageNum}</a></li>
		</c:forEach>
	  
		<li class="page-item ${board.last ? isDisabled : isNotDisabled}">
			<a class="page-link text-secondary" href="/board/index?page=${board.number + 1}">다음</a>
		</li>
	</ul>
</div>

</body>
</html>