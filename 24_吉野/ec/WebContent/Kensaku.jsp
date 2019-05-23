<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索画面</title>
</head>
<body style="text-align: center;">
	<form action="http://localhost:8080/ec/Kensaku" method="post">
		<h1>検索画面</h1>
		<br> <br> <input type="text" name="ken"><br> <br>
		カテゴリ
		<%--検索内容の取得 --%>
		<% ArrayList<String> cat = (ArrayList)session.getAttribute("cattt"); %>
		<%--カテゴリを表示 --%>
		<select name="category" align="center">
			<option value="0"></option>
			<%for(int i = 0; i< cat.size()-1; i++){ %>
			<option value="<%=i + 1%>"><%=cat.get(i) %></option>
			<%} %>
			<option value="<%=9%>"><%=cat.get(cat.size()-1) %></option>

		</select><br> <br> <input type="submit" value="検索">
	</form>
	<br>
	<% String syouhin = (String)session.getAttribute("syouhin"); %>
	<% if(syouhin == "null"){ %>
	<!-- 		何もしないよ -->
	<%}else{ %>
	<%--商品情報をテーブル形式で表示するための取得 --%>
	<% ArrayList<String> list = (ArrayList<String>)session.getAttribute("list"); %>
	<table border="1" width="500" cellspacing="0" cellpadding="5"
		bordercolor="black" align="center">
		<tr>
			<td>商品名</td>
			<td>価格</td>
			<td>詳細</td>
		</tr>
		<%--商品情報を画面に表示する為のループ --%>
		<% for(int i = 0; i < list.size(); i += 3){ %>
		<form action="http://localhost:8080/ec/syousai" method="post">
			<tr>
				<td><%=list.get(i) %></td>
				<td><%=list.get(i + 1) %></td>
				<td><input type="submit" value="詳細"> <input
					type="hidden" value="<%=list.get(i+2) %>" name="cod"></td>
			</tr>
		</form>
		<% } %>
		<%} %>

	</table>


</body>
</html>