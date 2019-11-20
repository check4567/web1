<%@page import="com.bigdata.mvc.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
</head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/screen.css">
<body>
	<%@ include file="session.jsp"%>	
	<table border="1">
		<tr>
			<th><font color="white">아이디</font></th>
			<th><font color="white">비밀번호</font></th>
			<th><font color="white">이메일</font></th>
			<th><font color="white">핸드폰</font></th>
			<th><font color="white">주소</font></th>
			<th><font color="white">성별</font></th>
			<th><font color="white">나이</font></th>
		</tr>
		<%
			List<MemberVO> mlist = (List<MemberVO>) request.getAttribute("mlist");
			for (int i = 0; i < mlist.size(); i++) {
				// Member m = mlist.get(i);
		%>
		<tr>
			<td><font color="white"><%=mlist.get(i).getId()%></font></td>
			<!-- m.getId() -->
			<td><font color="white"><%=mlist.get(i).getPwd()%></font></td>
			<!-- m.getPwd() -->
			<td><font color="white"><%=mlist.get(i).getEmail()%></font></td>
			<!-- m.getEmail() -->
			<td><font color="white"><%=mlist.get(i).getPhone()%></font></td>
			<!-- m.getPhone() -->
			<td><font color="white"><%=mlist.get(i).getAddr()%></font></td>
			<!-- m.getAddr() -->
			<td><font color="white"><%=mlist.get(i).getGender()%></font></td>
			<!-- m.getGender() -->
			<td><font color="white"><%=mlist.get(i).getAge()%></font></td>
			<!-- m.getAge() -->
		</tr>

		<%
			}
		%>
	</table>
</body>
</html>