<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入完了</title>
</head>
<body>
	<script type="text/javascript">
		function btnLink() {
			location.href = "search2.jsp"
		}
	</script>
	<h1 align="center">お買い上げありがとうございました！</h1>
	<br>
	<br>
	<form action="http://localhost:8080/EC/kanryou" method="POST">
		<table align ="center">
			<tr>
				<td><button type="button" onclick="btnLink()">買い物を続ける</button></td>

				<td><input type="submit" value="ログアウト"></td>
			</tr>
		</table>
	</form>
</body>
</html>