<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインページ</title>
<link rel="stylesheet" type="text/css" href="/Ex/css/login.css">
</head>
<body>
	<h1>ログイン</h1>
	<form action="/Ex/login" method="post">
			<div class="loginTable">
			<%
				Object s = request.getAttribute("errormsg");
				if (s != null) {
			%><div class="error"><%=s%></div>
			<%
				}
			%><div class="info">名前とパスワードを入力してください</div>
			<br>
				<table align="center">
					<table align="center">
						<tr>
							<td><div class="status">名前</div></td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td><div class="status">パスワード</div></td>
							<td><input type="password" name="password"></td>
						</tr>
					</table>
				</table>
			<div style="text-align: center">
				<input type="submit" value="ログイン">
			</div>
			</div>
	</form>
</body>
</html>