<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>

<body>
<h1>Implicit Object</h1>
リクエストパラメータの値は、
<% out.println("<b>"+request.getParameter("param")+"</b>"); %>
です。

</body>
</html>