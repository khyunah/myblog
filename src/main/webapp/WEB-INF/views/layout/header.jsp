<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<ul class="nav justify-content-center m-4">
<c:choose>
	<c:when test="${empty principal}">
		<li class="nav-item">
		  <h4><a class="nav-link text-secondary" href="/">메인</a></h4>
		</li>
		<li class="nav-item">
		  <h4><a class="nav-link text-secondary" href="#">나의 블로그</a></h4>
		</li>
		<li class="nav-item">
		  <h4><a class="nav-link text-secondary" href="/auth/login_form">로그인</a></h4>
		</li>
		<li class="nav-item">
		  <h4><a class="nav-link text-secondary" href="/auth/join_form">회원가입</a></h4>
		</li>
	</c:when>
	<c:otherwise>
		<li class="nav-item">
		  <h4><a class="nav-link text-secondary" href="/">메인</a></h4>
		</li>
		<li class="nav-item">
		  <h4><a class="nav-link text-secondary" href="#">나의 블로그</a></h4>
		</li>
		<li class="nav-item">
		  <h4><a class="nav-link text-secondary" href="#">글쓰기</a></h4>
		</li>
		<li class="nav-item">
		  <h4><a class="nav-link text-secondary" href="/user/my-info">내 정보</a></h4>
		</li>
		<li class="nav-item">
		  <button class="btn text-secondary" onclick="logout.logout()"><h4>로그아웃</h4></button>
		</li>
	</c:otherwise>
</c:choose>
	
</ul>
<hr/>
<br/>

<script src="/js/logout.js"></script>
