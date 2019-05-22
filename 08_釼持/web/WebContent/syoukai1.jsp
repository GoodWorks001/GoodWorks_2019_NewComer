<%@page import="web.Bean"%>
<%@ page language="java" contentType="text/html; charset=Windows-31J"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="Windows-31J">
<title>商品紹介1</title>
</head>
<body>
	<%
		Bean bean = new Bean();
		bean = (Bean) session.getAttribute("sessionAtt");
	%>
	<h1>
		<p align="center">商品紹介</p>
	</h1>
	<form action="http://localhost:8080/web/cart" method="POST">
		<image src=<%=request.getAttribute("PICNAME")%> align="left"
			width="350" height=350>
		<table border="1" width="400" cellspacing="0" cellpadding="5"
			bordercolor="black">
			<tr>
				<td>商品名</td>
				<td><%=bean.getName()%></td>
			</tr>
			<tr>
				<td>カテゴリ</td>
				<td><%=bean.getCat()%></td>
			</tr>
			<tr>
				<td>価格</td>
				<td>\<%=bean.getKakaku()%></td>
			</tr>
			<tr>
				<td>在庫</td>
				<td><%=bean.getZaiko()%></td>
			</tr>
			<tr>
				<td>商品紹介</td>
				<td><%=bean.getSyoukai()%></td>
			</tr>
		</table>
		</br>
		<div>
			個数<select name="kosuu">
				<%
					int num = (Integer) bean.getZaiko();
				%>

				<%
					for (int i = 1; i <= num; i++) {
				%>
				<option value=<%=i%>>
					<%=i%>
				</option>
				<%
					}
				%>
			</select>
		</div>
		</br>
		<input type="submit" value="カートへ">
	</form>
	<form action="http://localhost:8080/web/kensaku" method="POST">
		<input type="submit" value="戻る">
	</form>
</body>
</html>
