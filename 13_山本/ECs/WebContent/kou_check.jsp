<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購入確認画面</title>
<link rel="stylesheet" type="text/css" href="/ECs/css/style.css">
</head>
<body>
	<%ArrayList<String> name_list = (ArrayList<String>) session.getAttribute("namelist");%>
	<%ArrayList<String> price_list = (ArrayList<String>) session.getAttribute("pricelist");%>
	<%ArrayList<String> id_list = (ArrayList<String>) session.getAttribute("idlist");%>
	<%ArrayList<String> buy_list = (ArrayList<String>) session.getAttribute("buylist");%>
	<h1 align="center">
		購入してよろしいでしょうか？？
	</h1>
	<br>

	<table border="1" width="500" cellspacing="0" align="center" cellpadding="5" bordercolor="black">
			<tr>
				<th>商品名</th>
				<th>単価</th>
				<th>数量</th>
			</tr>
			<% for(int i=0;i<name_list.size();i++){ %>
			<tr>
				<td><%= name_list.get(i) %></td>
				<td><%= price_list.get(i) %></td>
				<td><%= buy_list.get(i) %></td>
			</tr>
			<% } %>
			<tr>
				<th colspan="2">消費税</th>
				<td><%= session.getAttribute("Tax") %></td>
			</tr>
			<tr>
				<th colspan="2">合計金額</th>
				<td><%= session.getAttribute("total") %></td>
			</tr>
		</table>

	<div align="center">
		<table>
			<tr>
				<td>
					<form action="serch.jsp" method="POST">
						<input type="submit" value="いいえ">
					</form>
				</td>
				<td>
					<form action="http://localhost:8080/ECs/kanryou" method="POST">
						<input type="submit" value="はい">
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>