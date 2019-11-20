<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
</head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/screen2.css">
<body>

<%@ include file="session.jsp" %> 

	<h1>
		<a href="memberSelect"><font color="white">회원정보</font></a> <font color="white">|</font>
		<a href="memberRegist"><font color="white">회원등록</font></a> <font color="white">|</font>
		<a href=""><font color="white">회원수정</font></a> <font color="white">|</font>
		<a href=""><font color="white">회원삭제</font></a> <font color="white">|</font>
	</h1>
	<hr>
	<div style="text-align: right">
		<font color="white"><%=session.getAttribute("id") %>님 환영합니다.</font><br> 
		<a href="logout"><font color="white">로그아웃</font></a>
	</div>












</body>
</html>