<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/background.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>

<body style="text-align:center">



  <h1>ログイン</h1>
  <form action ="loginServlet" method ="POST">


<div align="center">

<table>
 <tr>
  <td>名前</td>
  <td><input type="text" name="name"></td>
 </tr>
 <tr>
  <td>パスワード</td>
  <td><input type="password" name="pass"></td>
 </tr>

</table>



<input type="submit" value="LOGIN" class="button02">
</form>
<% String err1 =(String) request.getAttribute("err1"); %>
<% if (err1 != null) { %>
<%=err1 %>
<% } %>

<% String err2 =(String) request.getAttribute("err2"); %>
<% if (err2 != null) { %>
<%=err2 %>
<% } %>

</div>

</body>
</html>