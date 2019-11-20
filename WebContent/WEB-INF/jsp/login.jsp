<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>LogIn Form</title>
<link href='https://fonts.googleapis.com/css?family=Pacifico'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Arimo'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Hind:300'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="./style.css">
</head>
<body>

	<%
		String msg = (String) request.getAttribute("msg");
		if (msg == null) {
			msg = "";
		}
	%>
	<div id="login-button">
		<img
			src="https://dqcgrsy5v35b9.cloudfront.net/cruiseplanner/assets/img/icons/login-w-icon.png">
	
	</div>
	<div id="container" class="login">

		<h1>Login</h1>
		<span class="close-btn"> <img
			src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
		</span>
		<form action="<%=request.getContextPath()%>/loginController" method="post">
			<input type="text" name="id" placeholder="Username" >
    		<input type="password" name="pwd" placeholder="Password" >
    		<input type="submit" value="Login" class="login-button"/>

			
			
			
			<%=msg%>
			
			
			

		</form>
	</div>


	<!-- partial -->
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/gsap/1.16.1/TweenMax.min.js'></script>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="./script.js"></script>

</body>
</html>