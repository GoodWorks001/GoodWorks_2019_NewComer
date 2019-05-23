<%@page import="ec.LoginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="login" scope="request" class="ec.LoginDAO"/>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<form action="http://localhost:8080/EC/login" method="post">

	<h1 align="center">ログイン</h1>
	<div align ="center">
	<table>
		<tr>
			<td align="center">User-ID</td>
			<td align="center"><input type="text" size = 40; name="user_id" style = width:150px></td>
		</tr>
		<tr>
			<td align="center">パスワード</td>
			<td align="center"><input type="password" name="pass" style = width:150px></td>
		</tr>
	</table>

	<!-- 送信ボタンの設置 -->
	<input type="submit" value="ログイン">

	</div>

	</form>

</body>
</html>