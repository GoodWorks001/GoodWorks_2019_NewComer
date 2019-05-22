<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>検索画面</title>
</head>
<body background="C:/Users/education/Downloads/p0503_l.jpg" >

	<form action="http://localhost:8080/ecs/Kensaku2" method="post">
	<h1>
		<p align="center">検索</p>
	</h1>
	<h3>

	<p align="center"></p>
	</h3>
	<br>
	<p align="center">
		<input type="text" name="kensaku">
	</p>
	<br>
	<p align="center">
		カテゴリ<select name="category">
		<option value=""></option>
			<option value="調理家電"><%=request.getAttribute("catSUI") %></option>
			<option value="非売品"><%=request.getAttribute("catGOD") %></option>
			<option value="情報機器"><%=request.getAttribute("catPC") %></option>
		</select>
	</p>
	 <p align="center">
		<input type="submit" value="検索" >
	</p>
</form>
<%int flg=((Integer)(request.getAttribute("FLG") )).intValue();%>
<% if(flg!=0){%>
	<table border="1" width="500" cellspacing="0" align="center"
		cellpadding="5" bordercolor="black">
<%} %>
<% if(flg==1){%>
		<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>詳細</th>
		</tr>
		<tr>
			<td><%=request.getAttribute("NAME") %></td>
			<td>￥<%=request.getAttribute("PRICE") %></td>
			<td align="center"><form action="http://localhost:8080/ecs/Syousai" method="POST"">
					<input type="submit" value="詳細" name="ss"></td>
		</tr>
		</form>
<%} %>

<% if(flg==2){%>
<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>詳細</th>
		</tr>
		<tr>
			<td><%=request.getAttribute("NAME") %></td>
			<td>￥<%=request.getAttribute("PRICE") %></td>
			<td align="center"><form action="http://localhost:8080/ecs/Syousai" method="POST"">
					<input type="submit" value="詳細" name="ss"></td>
		</tr>
		</form>
		<%} %>

		<% if(flg==3){%>
		<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>詳細</th>
		</tr>
		<tr>
			<td><%=request.getAttribute("NAME") %></td>
			<td>￥<%=request.getAttribute("PRICE") %></td>
			<td align="center"><form action="http://localhost:8080/ecs/Syousai" method="POST"">
					<input type="submit" value="詳細" name="ss"></td>
		</tr>
		</form>
			<%} %>

			<% if(flg==4){%>
		<th>検索結果はありません</th>
			<%} %>


			</table>
</body>
</html>