<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購入画面</title>
</head>
<body>
<h1><p align="center">購入してもよろしいですか??</p></h1><br>

<table border="1" width="500" cellspacing="0"align="center" cellpadding="5" bordercolor="black">
	<tr>
		<th>商品名</th>
		<th>単価</th>
		<th>数量</th>
	</tr>
	<%--商品情報を格納した配列を取得 --%>
	<% ArrayList<String> Namelist = (ArrayList)session.getAttribute("cart"); %>
	<% ArrayList<Integer> Kakakulist = (ArrayList)session.getAttribute("cart1"); %>
	<% ArrayList<Integer> Kosulist = (ArrayList)session.getAttribute("cart2"); %>
	<% int total = 0; %>
	<%for(int i = 0; i<Namelist.size(); i++){ %>
	<tr>
		<td><%=Namelist.get(i) %></td>
		<td><%=Kakakulist.get(i) %></td>
		<td><%=Kosulist.get(i) %></td>
		<% total = total + Kakakulist.get(i) * Kosulist.get(i);%>
	</tr>
	<%} %>
	<tr>
		<td colspan="2">消費税</td>
		<% int zei = (int)(total * 0.08); %>
		<td>\<%=zei %></td>
	</tr>
	<tr>
		<td colspan="2">合計金額</td>
		<td>\<%= total + zei%></td>
	</tr>
</table>

<div align="center">
<form action = "cart.jsp">
<input type = "submit" value = "いいえ" >
</form>

<form action = "http://localhost:8080/ec/kounyuu" method = "post">
<input type = "hidden" value = "<%=total + zei %>" name = "all">
<input type = "submit" value = "はい" >
</form>

</div>
</body>
</html>