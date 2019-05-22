<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center;"bgcolor="#99FFCC">
	<h1>ログイン</h1>
	<form action="http://localhost:8080/iyada/loginservlet" method="post">
		<table align="center">
			<tr>
				<td>名前</td>
				<td><input type="text" name="name"></td>
			</tr>

			<tr>
				<td>パスワード</td>
				<td><input type="text" name="pw"></td>
			</tr>

		</table>

		<input type="submit" value="LOGIN">
	</form>
	<%
		String ses = (String) session.getAttribute("zyouhou");
	%>
	<%
		if (ses.equals("true")) {
	%>

	<%
		} else if (ses.equals("null")) {
	%>
	<h3>*名前またはパスワードを入力してください</h3>
	<%
		} else if (ses.equals("!=")) {
	%>
	<h3>*名前またはパスワードが一致しません</h3>
	<%
		}
	%>
</body>
</html>