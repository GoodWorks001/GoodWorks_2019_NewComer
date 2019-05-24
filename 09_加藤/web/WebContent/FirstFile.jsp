<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello World</h1>

<h1>Comment Tag</h1>
<!-- This is HTML Comment -->
<%-- This is JSP Comment --%>

<h1>Expression Tag</h1>
<p><%= 25*25 %></p>

<h1>Scriptlet Tag</h1>
<% for(int i=0; i<10; i++){ %>
<%= i %>
<% } %>

<h1>Declaration Tag</h1>
<%! int a=0; %>
<%= a++ %>
</body>
</html>