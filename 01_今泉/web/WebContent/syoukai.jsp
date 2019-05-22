<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="web.ProductBean"%>
<%@page import="web.CategoryBean"%>
<%@page import="web.DAO2"%>
<%@page import="web.CateDAO"%>
<%@page import="java.util.ArrayList"%>

<jsp:useBean id="Syouhin" class = "web.ProductBean" scope = "session"/>
<html>
<head>
<style>
h1 {
	text-align: center;
}
</style>
<meta charset="UTF-8">
<link rel="stylesheet" href="second.css">
<title>商品紹介</title>
</head>
<body>

<%

String im = Syouhin.getPro_img();
int ca = Syouhin.getCat_id();
int st = Syouhin.getStock_no();



%>

	<h1>商品紹介</h1>
	<%--画像 --%>
	<img src =<%= im %>>


	<table border>
		<tr>
			<td>商品名</td>
			<td><jsp:getProperty property="pro_name" name="Syouhin"/></td>
		</tr>
		<tr>
			<td>カテゴリ</td>
			<% if(ca == 100){%>
			<td>調理家電</td>
			<% } %>

			<% if(ca == 200){%>
			<td>非売品</td>
			<% } %>

			<% if(ca == 300){%>
			<td>情報機器</td>
			<% } %>

		</tr>
		<tr>
			<td>価格</td>
			<td>￥<jsp:getProperty property="pro_price" name="Syouhin"/></td>
		</tr>
		<tr>
			<td>在庫</td>
			<td><jsp:getProperty property="stock_no" name="Syouhin"/></td>
		</tr>
		<tr>
			<td>商品紹介</td>
			<td><jsp:getProperty property="pro_msg" name="Syouhin"/></td>
		</tr>
	</table>
	<form action="Cart" method="post">
		個数 <select name="order">
			<%
				for (int i = 1; i <=st; i++) {
			%>
			<option value=<%=i %>><%= i%></option>
			<%}%>
	</select>



	<input type="submit" value="カートへ">
	</form>

	<form action="search.jsp">
	<button type="submit" onclick="btnLink()">戻る</button>
	</form>


</body>
</html>