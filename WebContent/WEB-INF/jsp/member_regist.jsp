<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
</head>
<body>
	<%@ include file="menu.jsp"%>	
	<h1><font color="white">회원등록</font></h1>
	<form action="<%=request.getContextPath()%>/memberRegistController" method="post">
		<table border="1">
			<tr>
				<td><font color="white">아이디</font></td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td><font color="white">비밀번호</font></td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td><font color="white">이메일</font></td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td><font color="white">핸드폰</font></td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td><font color="white">주소</font></td>
				<td><input type="text" name="addr"></td>
			</tr>
			<tr>
				<td><font color="white">성별</font></td>
				<td>
					<input type="radio" name="gender" value="1"><font color="white">남자 </font>
				    <input type="radio" name="gender" value="2"><font color="white">여자</font>
				</td>
			</tr>
			<tr>
				<td><font color="white">나이</font></td>
				<td><input type="text" name="age"></td>
			</tr>
		</table>
		<input type="submit" value="등록">
	</form>
</body>
</html>