<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<font color="#005500">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>

</head>
<body   style="text-align: center;" background="C:/Users/education/Downloads/p0489_l.jpg">


	<h1>ログイン</h1>
	<form action="http://localhost:8080/ecs/login" method="POST">
		<div align="center" >
<table border="1" frame="box" >
				<tr>
				<td>名前</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type="password" name="password"></td>
				</tr>

				</div>
			</table>

			<input type="submit" value="LOGIN">
</form>
	</form>

</body>
</html>