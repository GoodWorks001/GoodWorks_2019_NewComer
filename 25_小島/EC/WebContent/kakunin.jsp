<%@page import="ec.ItemBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>確認</title>
</head>
<body>
<h1><p align="center">購入してよろしいでしょうか？？</p></h1><br>

<%ArrayList<ItemBean> itemList = (ArrayList<ItemBean>)session.getAttribute("cart"); %>


<center>

	<table border = "1" cellspacing="0" cellpadding="10">
	<% int num = 0; %>
		<thead>
			<tr height = "40">
				<th>商品名</th>
				<th>単価</th>
				<th>数量</th>
			</tr>
<% for(int i =0; i<itemList.size(); i++) {%>
		<tbody>
			<tr height = "40">
				<td><%=itemList.get(i).getName() %></td>
				<td>
				<%=itemList.get(i).getPrice()%>
				円</td>
				<td><%=itemList.get(i).getOrder()%></td>
				<% num=num+itemList.get(i).getPrice() * itemList.get(i).getOrder(); %>
			</tr>
		</tbody>
<% } %>
		<tbody>
			<tr height = "40">
				<th colspan="2">消費税</th>
				<td>
				<% int zei=(int)(num * 0.08); %>
				<%= zei %>

				円</td>
			</tr>
		</tbody>
		<tbody>
			<tr height = "40">
				<th colspan="2">合計金額</th>
				<td>
				<%= num+zei %>

				円</td>
			</tr>
		</tbody>
	</table><br>
<div align="center">
<table><tr>
<td>


<form action = "cart.jsp">
<input type="submit" align="center" value="買い物を続ける">
</form>
</td>
<td>
<form action ="updateServlet" method="post">
<input type = "hidden" value = "<%=num+zei %>" name = "all">
<input type="submit" value="購入">
</form>
</td>
</tr></table>
</div>
</body>
</html>