<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログインページ</title>
</head>
<body>
<FORM method="POST" action="http://localhost:8080/web1/Login">
<center><h1>LOGIN</h1></center>

<table  align ="center">
<tr>
     <td>名前</td>
        <td><input type = "text" name = "log"></td>
</tr>
<tr>
     <td>パスワード</td>
        <td><input type = "password" name = "pas"></td>


</tr>
</table>
<br>
   <center><input type = "submit" value = "LOGIN"></center>
</FORM>
<br>
<br>
<center><% String err1 =(String)request.getAttribute("err1");%>
<%if(err1 != null){ //エラー画面の処理の内容です%>
<%= err1 %>
<%} %>
<% String err2 =(String)request.getAttribute("err2");%>
<%if(err2 != null){ //エラー画面の処理の内容です%>
<%= err2 %>
<%} %>
</center>
</body>
</html>