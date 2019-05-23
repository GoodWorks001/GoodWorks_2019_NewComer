<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログインページ</title>
<link rel="stylesheet" type="text/css" href="/iyada/ec.css">
</head>
<body style="text-align: center;">
	<form action="http://localhost:8080/iyada/login" method="post">
		<p align="center">
		<h1>ログイン</h1>
		<br> <br>
		<table align="center">
			<tr>
				<td>
					<p>名前</p>
				</td>
				<td><input type="text" name="name" maxlength='16' autofocus>
				</td>
			</tr>

			<tr>
				<td>
					<p>パスワード</p>
				</td>
				<td><input type="password" name="pw" maxlength='16'></td>
			</tr>
		</table>
		<br> <input type="submit" value="LOGIN"><br> <br>
	</form>
	<% String ses = (String)session.getAttribute("zyouhou"); %>
	<%if(ses.equals("true")){ %>

	<%}else if(ses.equals("null")){ %>
	<h3>*名前またはパスワードを入力してください</h3>
	<%}else if(ses.equals("!=")){ %>
	<h3>*名前またはパスワードが一致しません</h3>
	<%} %>
	</p>
</body>
</html>