<%@page import="com.sun.xml.internal.ws.addressing.ProblemAction"%>
<%@page import="ec.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>詳細</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
HttpSession ses = request.getSession(true);
Product pro = new Product();
pro = (Product)ses.getAttribute("PRO");
%>
	<h1>
		<p align="center">商品紹介</p>
	</h1>

	<img src="<%=pro.getPro_img()%>" align="left">
	<table border="1" width="500" cellspacing="0" cellpadding="5"
		bordercolor="black">
		<tr>
			<td>商品名</td>
			<td><%=pro.getPro_name()%></td>
		</tr>
		<tr>
			<td>カテゴリ</td>
			<td><%=pro.getCat_name()%></td>
		</tr>
		<tr>
			<td>価格</td>
			<td>\<%=pro.getPro_price()%></td>
		</tr>
		<tr>
			<td>在庫</td>
			<td><%=pro.getStock()%></td>
		</tr>
		<tr>
			<td>商品紹介</td>
			<td><%=pro.getPro_msg()%></td>
		</tr>
	</table>
	</br>
	<form action ="CartServlet" method="post">
	<div>
		個数<select name="stock">
		<%for(int i = 1;i<=pro.getStock();i++){ %>
			<option value="<%=i%>"><%=i %></option>
			<%} %>
			</select>
	</div>

	<input type="submit" value="カートへ" >
	</form>
	<form action ="CatServlet" method="post">
	<input type="submit" value="戻る"></form>
</body>
</html>