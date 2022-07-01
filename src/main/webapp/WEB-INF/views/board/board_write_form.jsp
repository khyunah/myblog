<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<div class="form-group">
	  <label for="title">제목:</label>
	  <input type="text" class="form-control" id="title">
	</div>
	<div class="form-group">
	  <label for="content">내용:</label>
	  <textarea class="form-control summernote" rows="5" id="content"></textarea>
	</div>
	<button id="btn-save" class="btn btn-secondary" type="button">저장하기</button>
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