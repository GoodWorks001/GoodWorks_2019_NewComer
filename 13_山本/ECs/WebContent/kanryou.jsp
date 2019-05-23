<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購入完了</title>
<link rel="stylesheet" type="text/css" href="/ECs/css/style.css">
</head>
<body>
	<h1 align="center">お買い上げありがとうございました！</h1>
	<br>
	<div align="center">
		<table>
			<tr>
				<td>
					<form action="serch.jsp" method="POST">
						<input type="submit" value="買い物を続ける">
					</form>
				</td>
				<td>
					<form action="http://localhost:8080/ECs/logout" method="POST">
						<input type="submit" value="ログアウト">
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>