<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/web/Style.css">
<title>ログイン画面</title>
</head>
<body style="text-align: center;">
	<h1>ログイン</h1>
	<form action="http://localhost:8080/web/Lk" method="POST">
		<div align="center">
			<table>
				<tr>
					<td>名前</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type="text" name="password"></td>
				</tr>
				</table>
				</div>
<input type="submit" value="LOGIN">
	</form>
</body>
</html>