<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="first.css">
<meta charset="UTF-8">
<title>ログインページ</title>
</head>
<body style="text-align:center;">
<h1>ログイン</h1>
<form action="/web/Login1" method="post">


<%
 Object ses =request.getAttribute("errormsg");
if(ses != null){
%><div style="text-align:center"><font size="3" color="red" align="center"><b><%=ses %></b></font></div>
<%
}

%>

<table align="center">
<tr>
<td><b>名前</b></td>
<td><input type="text" name="name"></td>
</tr>

<tr>
<td><b>パスワード</b></td>
<td><input type="text" name="password"></td>
</tr>

</table>

<div style="text-align:center"><input type="submit" value="LOGIN"></div>

</form>
</body>
</html>