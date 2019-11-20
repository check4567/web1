<%
	if(session.getAttribute("id") == null){
		response.sendRedirect("login");
	}
%>