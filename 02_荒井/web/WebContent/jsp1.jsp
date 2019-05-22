<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>HelloWorld</h1>
<h1>Comment Tag</h1>

<!--  This is HTML Commet -->
<%--This is JSP Comment --%>


<p><%= 3*3 %></p>

<% for(int i = 0; i < 10; i++){ %>
<!--  ここだけHTML -->
<%= i %>
<% }  %>

<h1>Declaration Tag</h1>
<%! int a = 0; %>
<%= a++  %>


</body>
</html>