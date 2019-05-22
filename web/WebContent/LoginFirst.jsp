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
	<!-- 画面上部ログイン -->
	<h1>ログイン</h1>
	<br>
	<!-- 送信ボタンでECservletへ遷移する -->
	<form action="login1" method="POST">

		<!-- 名前入力フォーム -->
		名前　　　　
		<input type="text" name="name2"><br><br>
		<!-- パスワード入力フォーム -->
		パスワード
		<input type="password" name="pass2"><br><br>

	<!-- ログインボタン -->
	<input type="submit" value="LOGIN">

	</form>
	</center>
</body>
</html>