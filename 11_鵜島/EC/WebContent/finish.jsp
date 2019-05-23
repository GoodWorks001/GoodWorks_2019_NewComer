<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入完了</title>
</head>
<body>

	<h1 align="center">お買い上げありがとうございました！</h1>
	<br>
	<br>

	<div align="center">

	<table>
		<tr>
			<td>
			<form action="search.jsp" method="post">
				<input type="submit" value="買い物を続ける" >
			</form>
			</td>
			<td>
				<form action="http://localhost:8080/EC/logout" method="post">
					<input type="submit" value="ログアウト">
				</form>
			</td>
		</tr>
	</table>

	</div>

</body>
</html>