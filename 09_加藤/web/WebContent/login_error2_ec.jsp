<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="design_login.css">
<title>ログインページ</title>
</head>
<body style="text-align:center;">
<h1>ログイン</h1>
<form action="http://localhost:8080/web/login" method="POST">
<div align="center">

<table>
<tr><td>名前</td><td><input type="text" name="name"></td></tr>
<tr><td>パスワード</td><td><input type="password" name="password"></td></tr>
<%-- エラーメッセージとして以下の文章が表示される --%>
<tr><td></td><td style="color:red;">情報が未入力です。</td></tr>
<tr><td></td><td><input type="submit" value="LOGIN"></td></tr>
</table>
</div>
</form>
</body>
</html>
</html>