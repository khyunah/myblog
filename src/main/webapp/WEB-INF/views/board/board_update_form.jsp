<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<div class="form-group">
	<input type="hidden" id="boardId" value="${board.id}">
	  <label for="title">제목:</label>
	  <input type="text" class="form-control" id="title" value="${board.title}">
	</div>
	<div class="form-group">
	  <label for="content">내용:</label>
	  <textarea class="form-control summernote" rows="5" id="content">${board.content}</textarea>
	</div>
	<button id="btn-update" class="btn btn-secondary" type="button">수정하기</button>
</div>
<script>
   $('.summernote').summernote({
     placeholder: 'Hello Bootstrap 4',
     tabsize: 2,
     height: 300
   });
</script>
<script src="/js/board.js"></script>
</body>
</html>