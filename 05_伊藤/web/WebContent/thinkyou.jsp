<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ありがとうございました</title>
</head>
<body>
	<%-- xmlに飛ばす --%>
	<form action="owari" method="post">
		<div align="center">
			<h1>お買い上げありがとうございました！</h1>
			<br><br>

			<table align="center">
			<tr>
				<td>
					<button type="submit" name="next" value="next">買い物を続ける</button>
				</td>
				<td>
					<button type="submit" name="back" value="back">ログアウト</button>
				</td>
			</tr>
		</table>

</body>
</html>