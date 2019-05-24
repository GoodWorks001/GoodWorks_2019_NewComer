<%@page import="ecs.CartBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body >
<%
CartBean cb = new CartBean();
cb=(CartBean)session.getAttribute("NAME");



%>
<form action="http://localhost:8080/ecs/Cart" method="POST">
	<h1>
		<p align="center">商品紹介</p>
	</h1>

	<image src=<%=session.getAttribute("IMG") %> align="left">

	<table border="1" width="350" height="350" cellspacing="0" cellpadding="5"
		bordercolor="black">

		<tr>
			<td>商品名</td>
			<td><%=cb.getName()%></td>
		</tr>
		<tr>
			<td>カテゴリ</td>
			<td><%=cb.getCat()%></td>
		</tr>
		<tr>
			<td>価格</td>
			<td>￥<%=cb.getKakaku()%></td>
		</tr>
		<tr>
			<td>在庫</td>
			<td><%=cb.getZaiko()%></td>
		</tr>
		<tr>
			<td>商品紹介</td>
			<td><%=cb.getSyoukai()%></td>
		</tr>
	</table>
	</br>
	<div>
		個数<select name="category" >
		<%
		int num=((Integer)(cb.getZaiko() )).intValue();
		%>

		<%for(int i=1;i<=num;i++){%>
		<option value=<%=i %> >
<%=i%>
</option>
		<%
		}
		%>
</select>
	</div>
	</br>

	<input type="submit" value="カートへ" >
	</form>

	<form action="http://localhost:8080/ecs/Kensaku" method="POST">
	<input type="submit" value="戻る" >
	</form>
</body>
</html>