<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="design_login.css">
<title>ログイン画面</title>
</head>

<body style="text-align:center;">
<h1>ログイン</h1>
<%-- Servletを連結させるためのform設定 --%>
<form action="http://localhost:8080/web/login" method="POST">
<div align="center">
<table>
<%-- 名前及びパスワードを入力するための入力欄の生成 --%>
<tr><td>名前</td><td><input type="text" name="name"></td></tr>
<tr><td>パスワード</td><td><input type="password" name="password"></td></tr>
<%-- データ送信型ボタンの作成 --%>
<tr><td></td><td></td></tr>
<tr><td></td><td><input type="submit" value="LOGIN"></td></tr>
</table>
</div>
</form>
</body>
</html>