<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="web1.ProBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
</head>
<body>

	<%
		ArrayList<ProBean> cart = (ArrayList<ProBean>) session.getAttribute("cart");
		//変数宣言↑
	%>

	<%
		int sum = 0;
	%>
	<%
		int tax = 0;
	%>
	<h1>
		<p align="center">Cart</p>
	</h1>
	<br>

	<table border="1" width="500" cellspacing="0" align="center"
		cellpadding="5" bordercolor="black">
		<tr>
			<th>商品名</th>
			<th>単価</th>
			<th>数量</th>
		</tr>

			<%
				for (int i = 0; i < cart.size(); i++) {
					ProBean pro = cart.get(i); //←ArrayListのi番目のインスタンスを取得。　(型があうから）（インスタンスしたのをインスタンスする)
					sum = sum + (pro.getPro_price() * pro.getT_kazu());
			%>

			<tr>
			<td><%= pro.getPro_name() %></td>
			<td><%= pro.getPro_price() %></td>
			<td><%= pro.getT_kazu() %></td>
			</tr>
			<%
				}
			%>



		<tr>
			<th colspan="2">消費税</th>
			<td>￥<%= tax = ((int) (sum * 0.08))  %></td>
		</tr>
		<tr>
			<th colspan="2">合計金額</th>
			<td>￥<%=sum + tax %></td>
		</tr>
	</table>

	<div align="center">
		<table>
			<tr>
				<td>
					<form action="Search.jsp">
						<input type="submit" align="center" value="買い物を続ける">
					</form>
				</td>
				<td>
					<form action="check.jsp">
						<input type="submit" value="購入">
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>