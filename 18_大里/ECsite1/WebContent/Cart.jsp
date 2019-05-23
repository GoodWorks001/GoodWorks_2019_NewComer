<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カート画面</title>
</head>
<body>
<center>
	<h1>カート</h1>
	<table border = "1" >
		<thead>
			<tr >
				<th>商品名</th>
				<th>単価</th>
				<th>数量</th>
			</tr>
		</thead>
		<% HttpSession sess = request.getSession(false); %>
		<% HashMap <String,Integer[]>hp = (HashMap)sess.getAttribute("cart");%>
		<% Iterator it = hp.keySet().iterator(); %>
		<% Integer [] info = {0,0}; %>

		<% int total = 0; %>
		<% while(it.hasNext()) { %>
			<% String key = (String)it.next(); %>
			<% info = hp.get(key);%>
		<tbody>
			<tr height = "40">
				<td><%= key%></td>
				<td>￥
				<%= info[1]%>
				</td>
				<td><%= info[0]%></td>
			</tr>
		</tbody>
		<% total += info[1] * info[0]; %>
		<% } %>
		<tbody>
			<tr height = "40">
				<th colspan="2">消費税</th>
				<td>￥
				<%=Math.round(total * 0.08) %>
				</td>
			</tr>
		</tbody>
		<tbody>
			<tr height = "40">
				<th colspan="2">合計金額</th>
				<td>￥
				<%=Math.round(total * 1.08)%>
				</td>
			</tr>
		</tbody>
	</table><br>
	<a href = "Search.jsp"><input type = "button" value = "買い物を続ける"></a>
	<a href = "Confirm.jsp"><input type = "button" value = "購入"></a>
</center>
</body>
</html>