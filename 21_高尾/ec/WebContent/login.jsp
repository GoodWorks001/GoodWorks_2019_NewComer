<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
<%
	Object s = request.getAttribute("errormsg");
	if(s != null){
		%>
<div style="text-align:center"><font size="3" color="red" aling="center"><%=s%></font></div>
		<%
	}
%>
<center>
<form method="POST" action="http://localhost:8080/ec/login">
<h1>ログイン</h1>
<table>
<tr>
<td>名前</td>
<td><input type ="text" name="name"></td>
</tr>
<tr>
<td>パスワード</td>
<td><input type ="password" name="pw"></td>
</tr>
</table>

<input type ="submit" value="LOGIN">
</form>

</center>
</body>
</html>