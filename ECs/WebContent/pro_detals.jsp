<%@page import="ec.categoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ec.SearchBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品紹介1</title>
<link rel="stylesheet" type="text/css" href="/ECs/css/style.css">
</head>
<body>
	<%
		ArrayList<String> item_list = (ArrayList<String>) session.getAttribute("syousaiList");
	%>


	<h1 align="center">商品紹介</h1>

	<image src=<%=item_list.get(5)%> align="left"></image>
	<table border="1" width="500" cellspacing="0" cellpadding="5"
		bordercolor="black" align="right" align="center">
		<tr>
			<td>商品名</td>
			<td><%=item_list.get(1)%></td>
		</tr>
		<tr>
			<td>カテゴリ</td>
			<%
				if (Integer.parseInt(item_list.get(4)) == 1) {
			%>
			<td>スマートフォン</td>
			<%
				}
			%>
			<%
				if (Integer.parseInt(item_list.get(4)) == 2) {
			%>
			<td>ガラケー</td>
			<%
				}
			%>
			<%
				if (Integer.parseInt(item_list.get(4)) == 3) {
			%>
			<td>ゲーム機</td>
			<%
				}
			%>
		</tr>
		<tr>
			<td>価格</td>
			<td><%=item_list.get(3)%></td>
		</tr>
		<tr>
			<td>在庫</td>
			<td><%=item_list.get(2)%></td>
		</tr>
		<tr>
			<td>商品紹介</td>
			<td><%=item_list.get(6)%></td>
		</tr>

	</table>
	<table align="center">
		<tr>
			<td><form action="http://localhost:8080/ECs/cart" method="POST">
					個数 <select name="stock">
						<option value=""></option>
						<%
							for (int i = 1; i <= Integer.parseInt(item_list.get(2)); i++) {
						%>
						<option value=<%=i%>><%=i%></option>
						<%
							}
						%>
					</select> <input type="hidden" value=<%=item_list.get(1)%> name="proName">
					<input type="hidden" value=<%=item_list.get(0)%> name="proId">
					<input type="hidden" value=<%=item_list.get(3)%> name="proPrice">



					<input type="submit" value="カートへ" name="cart">
				</form></td>

			<td><form action="serch.jsp">
					<input type="submit" value="戻る">
				</form></td>
		</tr>

	</table>
</body>
</html>