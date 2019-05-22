<%@page import="iyada.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購入確認ページ</title>
<link rel="stylesheet" type="text/css" href="/iyada/ec.css">
</head>
<body>
	<h1>
		<p align="center">購入してもよろしいですか??</p>
	</h1>
	<br>

	<table border="1" width="500" cellspacing="0" align="center"
		cellpadding="5" bordercolor="black">
		<tr>
			<th>商品名</th>
			<th>単価</th>
			<th>数量</th>
		</tr>
		<%--各情報格納用配列を取り出す --%>
		<%
			ArrayList<ProductBean> list = (ArrayList) session.getAttribute("cart");
		%>
		<%--合計金額格納用変数の宣言 --%>
		<%
			int total = 0;
		%>
		<%--カート内情報の表示 --%>
		<%
			for (int i = 0; i < list.size(); i++) {
		%>
		<tr>
			<td><%=list.get(i).getPro_name()%></td>
			<td><%=list.get(i).getPro_price()%></td>
			<td><%=list.get(i).getKosuu()%></td>
			<%--合計金額の計算 --%>
			<%
				total = total + list.get(i).getAll();
			%>
		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="2">消費税</td>
			<%--消費税を計算し表示 --%>
			<%
				int zei = (int) (total * 0.08);
			%>
			<td>\<%=zei%></td>
		</tr>
		<tr>
			<td colspan="2">合計金額</td>
			<%--込々の合計価格を表示 --%>
			<td>\<%=total + zei%></td>
		</tr>
	</table>

	<div align="center">
		<table>
			<tr>
				<td>
					<form action="cart.jsp">
						<input type="submit" value="いいえ">
					</form>
				</td>
				<td>
					<form action="http://localhost:8080/iyada/kounyuu" method="post">
						<input type="hidden" value="<%=total + zei%>" name="all">
						<input type="submit" value="はい">
					</form>
				</td>
			</tr>
	</div>
	</table>
</body>
</html>