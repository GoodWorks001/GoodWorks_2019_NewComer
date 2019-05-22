<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>HelloWorld</h1>
<!-- this is HTML comment -->
<%-- this is JSP comment --%>
<%-- 式を書く時、；は必要ない --%>
<h1>Expression Tag</h1>
<p><%= 2*3 %></p>

<%-- 実行したいjavaのソースコード--%>
<h1>Scriptlet Tag</h1>
<%for (int i=0;i<10;i++){ %>
<%=i %>
<% } %>

<%-- 変数値が保持される --%>
<h1>Declaration</h1>
<%! int a =0; %>
<%= a++ %>


</body>
</html>