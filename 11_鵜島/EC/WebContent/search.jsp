<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<%@ page import="java.util.ArrayList"%>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
</head>
<body>

	<% ArrayList<String> list = (ArrayList<String>)session.getAttribute("categoryList"); %>
	<form action="http://localhost:8080/EC/search" method="post">
		<h1 align="center">検索</h1>

		<p align="center">
			<input type="text" name="search">
		</p>
		<br>

		<p align="center">
			カテゴリー <select name="category">
			<option value = "0"></option>
			<% int x = 1; %>
				<% for(String s : list){ %>
					<option value = "<%= x %>"><%= s %></option>
					<% x+=1; %>
				<% } %>
			</select>
		</p>

		<!-- 送信ボタンの設置 -->
		<p align="center">
			<input type="submit" value="検索">
		</p>
	</form>

</body>
</html>