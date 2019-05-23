<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
<center>

	<h1>ログイン</h1>
	<br>

	<form action="Login" method="POST">
	<table>
		<tr><td>名前</td>
		<td><input type="text" name="name2"></td></tr>
		<tr><td>パスワード</td>
		<td><input type="password" name="pass2"></td></tr>
 </table>
<br>
<input type="submit" value="LOGIN">


	</form>

	<% String err2 =(String)request.getAttribute("err2"); %>
	<%if (err2!=null){%>
	<%= err2 %>
	<% } %>

	<% String err1 =(String)request.getAttribute("err1"); %>
	<%if (err1!=null){%>
	<%= err1 %>
	<% } %>

	</center>
</body>
</html>