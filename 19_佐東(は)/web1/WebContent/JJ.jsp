<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Long Long Story</title>
</head>
<body>
<h1>HelloWorld</h1>
<br>
<h1>Comment Tag</h1>

<!--  This is HTML Comment  -->
<%-- This is JSP Comment --%>

<p><%= 3*3*Math.PI %></p>

<h1>Scriptlet Tag</h1>
<% for(int  x = 0; x<10; x++){ %>
<%= x%>
<% }%>

<h1>Declaration Tag</h1>
<%! int a =0; %>
<%= a++ %>


</body>
</html>