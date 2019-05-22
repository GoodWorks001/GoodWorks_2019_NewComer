<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインページ</title>
<link rel="stylesheet" type="text/css" href="/web/design.css">
</head>
<body>
	<!-- ここからスタート -->
<body style="text-align: center;">
	<h1>ログイン</h1>
	<!-- LogKenServletへ -->
	<form action="http://localhost:8080/web/logken" method="POST">
		<div align="center">
			<table border="1">
				<tr>
					<td>名前</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type="text" name="password"></td>
				</tr>
			</table>
			<input type="submit" value="LOGIN" class="btn-circle-fishy">
		</div>
	</form>
</body>
</html>