<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入完了画面</title>
</head>
<body>
	<h3 align="right"><%="ログイン中：" + session.getAttribute("login_name")%></h3>
	<h1>
		<p align="center">お買い上げありがとうございます！</p>
	</h1>
	<%
		ArrayList<String> errors = (ArrayList<String>) session.getAttribute("errorMsg");
	%>
	<%
		for (int i = 0; i < errors.size(); i++) {
	%>
	<div style="text-align: center"><font size="3" color="red"><b><%=errors.get(i)%></b></font></div>
		<%
			}
		%>
		<br>
		<form action="/Ex/order" method="post">
			<div align="center">
				<table>
					<tr>
						<td><button type="submit" name="back" value="back">買い物を続ける</button></td>
						<td><button type="submit" name="logout" value="logout">ログアウト</button></td>
					</tr>
				</table>
			</div>
		</form>
</body>
</html>