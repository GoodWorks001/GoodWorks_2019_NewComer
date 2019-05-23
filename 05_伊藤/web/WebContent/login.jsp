<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
</head>
<body>
	<div>
		<%-- xmlに飛ばす --%>
		<form action="http://localhost:8080/web/Login" method="post">

			<div align="center">
				<h1>ログイン</h1>
				<%
					String msg = (String) request.getAttribute("msg");
					if (msg == null) {
						msg = "";
					}
				%>
				<p><%=msg%></p>


				<table>
					<tr>
						<td>名前</td>
						<td><input type="text" name="name"></td>
					</tr>



					<tr>
						<td>パスワード</td>
						<td><input type="password" name="pw"></td>


					</tr>
				</table>
				<br> <input type="submit" value="LOGIN">
			</div>
</body>
</html>