<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Complete</title>
</head>
<body>
	<h1>
		<p align="center">お買い上げありがとうございました！</p>
	</h1>
	<br>
	<div align="center">
		<table>
			<tr>
				<td>
					<form action="Search.jsp">
						<input type="submit" value="買い物を続ける">
					</form>
				</td>
				<td>
					<form action="LogoutServlet" method="post">
						<input type="submit" value="ログアウト">
					</form>
					</td>
					</table>
</body>
</html>