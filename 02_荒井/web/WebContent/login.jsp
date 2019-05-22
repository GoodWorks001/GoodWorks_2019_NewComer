<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="ec.css">
<title>ログイン</title>
</head>

<!-- 文字を中央寄せ -->
<div class="box4">
<body>


	<h1 align="center">ログイン</h1>
	<form action="/web/Login" method="post">   <!-- Loginサーブレットにとぶ -->


		<%
			Object s = request.getAttribute("errormsg");
			if (s != null) {
		%><div style="text-align: center">
			<font size="3" color="red" align="center"><b><%=s%></b></font>
		</div>
		<%
			}
		%>
		<!-- どちらかが入力されていなかったらエラーメッセージ表示 -->
		<div style="text-align: center">
			<b>名前とパスワードを入力してください</b>
		</div>
		<br>

        <!-- 配置中央寄せ -->
		<table align="center">
			<tr>
				<td><b>名前</b></td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><b>パスワード</b></td>
				<td><input type="text" name="passward"></td>
			</tr>
		</table>
		<br>

		<div style="text-align: center">
			<input type="submit" value="ログイン">
		</div>
		<br>

	</form>
</body>
</div>
</html>
