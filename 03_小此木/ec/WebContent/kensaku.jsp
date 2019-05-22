<%@page import="ec.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href = "style.css" rel= "stylesheet" media = "all">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索</title>
</head>
<body>
<div>
<%
request.setCharacterEncoding("UTF-8");
ArrayList<Category> catlist = new ArrayList<Category>();
catlist =(ArrayList<Category>)session.getAttribute("CATLIST");
%>
	<form action ="KensakuServlet" method="post">
		<h1>
			<p align="center">検索</p>
		</h1>
		<br>
		<p align="center">
			<input type="text" name="kensaku">
		</p>
		<br>
		<p align="center">
			カテゴリ<select name="category">
			<option value=""></option>
			<%for(int i =0; i<catlist.size();i++){
			Category cat = new Category();
			cat= catlist.get(i);
			%>
				<option value="<%=cat.getCat_id() %>"><%=cat.getCat_name() %></option>
			<% } %>
			</select>
		</p>
		<p align="center">
			<input type="submit" value="検索">
		</p>
	</form>
</div>
</body>
</html>