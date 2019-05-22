<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインエラー</title>
</head>
<body>
	<h1>ログインエラー</h1>
	<form action="http://localhost:8080/web/logback" method="POST">
		<div align="center">
			名前かパスワードが間違っています <input type="submit" value="LOGIN">
		</div>
	</form>
</body>
</html>