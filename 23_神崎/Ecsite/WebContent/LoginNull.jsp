<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
</head>
<body>
	<center>


		<h1>ログイン</h1>
		<br>

		<h2>名前またはパスワードを入力して下さい。</h2>

		<form action="/Ecsite/ECservlet" method="POST">

			名前 <input type="text" name="name2"><br>
			<br> パスワード <input type="password" name="pass2"><br>
			<br>

			<!-- ログインボタン -->
			<input type="submit" value="LOGIN">

		</form>
	</center>
</body>
</html>