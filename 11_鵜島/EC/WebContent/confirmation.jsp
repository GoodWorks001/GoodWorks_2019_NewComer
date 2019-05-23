<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList"%>
<html>
<head>
<meta charset="UTF-8">
<title>購入確認画面</title>
</head>
<body>

	<h1 align="center">購入してよろしいでしょうか？</h1>

	<div align="center">

	<table border=1 style = width:300px>
		<tr>
			<td align="center">商品名</td>
			<td align="center">単価</td>
			<td align="center">数量</td>
		</tr>
		<%ArrayList<String> namelist = (ArrayList<String>)session.getAttribute("namelist"); %>
			<%ArrayList<String> pricelist = (ArrayList<String>)session.getAttribute("pricelist"); %>
			<%ArrayList<String> cdlist = (ArrayList<String>)session.getAttribute("cdlist"); %>
			<%ArrayList<String> stocklist = (ArrayList<String>)session.getAttribute("stocklist"); %>

			<% for(int i = 0; i < namelist.size(); i++) { %>
		<tr>
			<td align="center"><%= namelist.get(i) %></td>
			<td align="center">&yen; <%= pricelist.get(i) %></td>
			<td align="center"><%= stocklist.get(i) %></td>
		</tr>
		<% } %>


	</table>

	<table border = 1 style = width:300px>
		<tr>
			<td>消費税</td>
			<td>&yen; <%= session.getAttribute("tax")  %></td>
		</tr>
		<tr>
			<td>合計金額</td>
			<td>&yen; <%= session.getAttribute("goukei") %></td>
		</tr>
	</table>


	<table>
		<tr>
			<td>
			<form action="search.jsp" method="post">
				<input type="submit" value="いいえ" >
				</form>
				</td>

			<td>

				<form action="http://localhost:8080/EC/finish" method="post">
					<input type="submit" value="はい" >
				</form>

			</td>
		</tr>
	</table>

	</div>

</body>
</html>