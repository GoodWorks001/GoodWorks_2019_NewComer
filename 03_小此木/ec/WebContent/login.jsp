<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="style.css" rel="stylesheet" media="all">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
</head>
<body style="text-align: center;" class="lbody">
	<div class="login">
		<h1 class="lh">Login</h1>
		<form class="lm" action="http://localhost:8080/ec/LoginServlet"
			method="post">
			<p class="id">
				User ID:<input type="text" name="user_id" class="hoge">
			</p>
			<br>
			<p class="pas">
				Password:<input type="password" name="login_pw" class="hoge">
			</p>
			<p class="btnm">
				<input type="submit" value="LOGIN" class="btn">
			</p>
		</form>
	</div>
</body>
</html>