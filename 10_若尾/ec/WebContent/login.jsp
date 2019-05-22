<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h1>ログイン画面</h1></center>
	<form action="http://localhost:8080/ec/login" method="POST">
		<center><table>
			<!-- 名前 -->
			<br>
							<th>名前</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<!-- パスワード -->
				<th>パスワード</th>
				<td><input type="password" name="pass"></td>
			</tr>
		</table></center>
		<!-- login開始ボタン -->
		<center><input type="submit" value="Login"></center>

	</form>
</body>
</html>