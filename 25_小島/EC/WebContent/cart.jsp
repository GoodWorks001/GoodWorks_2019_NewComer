<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="ec.ItemBean,java.util.ArrayList"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カート</title>
</head>
<body>

<%ArrayList<ItemBean> itemList = (ArrayList<ItemBean>)session.getAttribute("cart"); %>






<center>
	<h1>カート</h1>
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


<form action = "search2.jsp">
<input type="submit" align="center" value="買い物を続ける">
</form>
</td>
<td>
<form action ="kakunin.jsp" >
<input type="submit" value="購入">
</form>
</td>
</tr></table>
</div>



</body>
</html>