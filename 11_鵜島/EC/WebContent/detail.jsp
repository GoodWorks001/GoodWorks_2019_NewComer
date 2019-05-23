<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList"%>
<html>
<head>
<meta charset="UTF-8">
<title>商品紹介</title>
</head>
<body>

	<%ArrayList<String> detailList = (ArrayList<String>)session.getAttribute("detail"); %>

	<h1 align="center">商品紹介</h1>

	<img src=<%= detailList.get(4) %> align="left" width = 50% >

	<table border=1>
		<tr>
			<td>商品名</td>
			<td><%= detailList.get(0) %></td>
		</tr>
		<tr>
			<td>カテゴリー</td>
			<% if(Integer.parseInt(detailList.get(5)) == 1){ %>
				<td>テスト</td>
			<% } %>
			<% if(Integer.parseInt(detailList.get(5)) == 2){ %>
				<td>家電</td>
			<% } %>
			<% if(Integer.parseInt(detailList.get(5)) == 3){ %>
				<td>本</td>
			<% } %>
		</tr>
		<tr>
			<td>価格</td>
			<td> &yen; <%= detailList.get(1) %></td>
		</tr>
		<tr>
			<td>在庫</td>
			<td><%= detailList.get(2) %></td>
		</tr>
		<tr>
			<td>商品紹介</td>
			<td><%= detailList.get(3) %></td>
		</tr>

	</table>








	<table>
		<tr>
			<td>
				<form action="cart" method="post">

					<select name="stockNum">
						<% for(int i = 1; i <= Integer.parseInt(detailList.get(2)); i++){ %>
						<option value="<%= i %>"><%= i %></option>
						<%} %>
					</select>
					<input type="hidden" value=<%= detailList.get(0) %> name="pro_name">
					<input type="hidden"value=<%= detailList.get(1) %> name="pro_price">
					<input type="hidden" value=<%= detailList.get(6) %> name="id">
					<input type="hidden" value=<%= detailList.get(2) %> name="stock">

					<input type="submit" value="カートへ">
				</form>

			</td>

			<td>
				<form action="search.jsp" method="post">
					<input type="submit" value="戻る">
				</form>
			</td>
		</tr>

	</table>




</body>
</html>