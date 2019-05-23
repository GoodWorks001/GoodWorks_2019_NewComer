<%@page import="Search.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート画面</title>
</head>
<body>
<%
ArrayList<ProductBean> Cart = (ArrayList<ProductBean>)session.getAttribute("CART");
//変数宣言
int sum = 0;
int zei = 0;


%>


	<h1>
		<p align="center">カート</p>
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
		for(int i=0;i<Cart.size();i++){
		ProductBean pro = Cart.get(i);
		sum = sum+(pro.getPro_price()*pro.getT_kazu());

		%>
		<tr>
			<td><%=pro.getPro_name() %></td>
			<td>￥<%=pro.getPro_price() %></td>
			<td><%=pro.getT_kazu() %></td>

		</tr>

		<% }%>
		<tr>
			<th colspan="2">消費税</th>
			<td><%=zei = ((int)(sum*0.08)) %></td>
		</tr>
		<tr>
			<th colspan="2">合計金額</th>

			<td>￥<%=sum +zei %></td>
		</tr>
	</table>

	<div align="center">
		<table>
			<tr>
				<td>
					<form action="Search.jsp" method="post">
						<input type="submit" align="center" value="買い物を続ける">
					</form>
				</td>
				<td>
					<form action="Kakunin.jsp">
						<input type="submit" value="購入">
					</form>
				</td>
			</tr>
		</table>
	</div>




</body>
</html>