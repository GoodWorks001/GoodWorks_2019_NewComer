<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Login.css">
<meta charset="UTF-8">
<title>LOGINPAGE</title>
</head>
<body>
<!-- <div class="BoxImage"> -->
<div class="box">
<div>
<h1>LOGIN</h1>
  <form name="form_name" action="loginservlet" method="POST">

    <table align="center">
      <tr>
        <td>NAME</td>
        <td><input type="text" name="name"></td>
      </tr>
      <tr>
        <td>PASS</td>
        <td><input type="text" name="password"></td>
      </tr>
    </table>

    <a href="javascript:form_name.submit()" class="btn-square">LOGIN</a>
  </form>
  <br>

  <!-- ユーザ名かパスワードが入力されていないときの出力 -->
  <%
    String err1 = (String) request.getAttribute("err1");
  %>
  <%
    if (err1 != null) {
  %>
  <%=err1%>
  <%
    }
  %>
	<br>
  <!-- 該当するユーザが存在しないときの出力 -->
  <%
    String err2 = (String) request.getAttribute("err2");
  %>
  <%
    if (err2 != null) {
  %>
  <%= err2 %>
  <% } %>
</div>
</div>
</body>
</html>