<%@ page language="java" contentType="text/html; charset=Windows-31J"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="Windows-31J">
<title>検索ページ</title>
</head>
<body>
	<form action="http://localhost:8080/web/kensaku" method="POST">
		<h1>
			<p align="center">検索</p>
		</h1>
		<h3>
			<p align="center">検索結果が優先です！</p>
		</h3>
		<br>
		<p align="center">
			<input type="text" name="kensaku" size="40">
		</p>
		<br>
		<p align="center">
			カテゴリ<select name="category">
				<option value="なし">カテゴリ名</option>
				<option value="調理家電"><%=request.getAttribute("DLKCATEGORY1")%></option>
				<option value="非売品"><%=request.getAttribute("DLKCATEGORY2")%></option>
				<option value="情報機器"><%=request.getAttribute("DLKCATEGORY3")%></option>
			</select>
		</p>
		<p align="center">
			<input type="submit" value="検索">
		</p>
	</form>
	<%
		int num = (Integer) request.getAttribute("NUM");
	%>
	<%
		if (num != 0) {
	%>
	<table border="1" width="500" cellspacing="0" align="center"
		cellpadding="5" bordercolor="black">

		<%
			}
		%>
		<%
			if (num == 1) {
		%>
		<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>詳細</th>
		</tr>
		<tr>
			<td><%=request.getAttribute("DLKNAME")%></td>
			<td>\<%=request.getAttribute("DLKPRICE")%></td>

			<td align="center"><form
					action="http://localhost:8080/web/kensyou" method="POST">
					<input type="submit" value="詳細1" name="syousai"></td>
		</tr>
		</form>

		<%
			}
		%>
		<%
			if (num == 2) {
		%>
		<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>詳細</th>
		</tr>
		<tr>
			<td><%=request.getAttribute("DLKNAME")%></td>
			<td>\<%=request.getAttribute("DLKPRICE")%></td>

			<td align="center"><form
					action="http://localhost:8080/web/kensyou" method="POST">
					<input type="submit" value="詳細2" name="syousai"></td>
		</tr>
		</form>

		<%
			}
		%>
		<%
			if (num == 3) {
		%>
		<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>詳細</th>
		</tr>
		<tr>
			<td><%=request.getAttribute("DLKNAME")%></td>
			<td>\<%=request.getAttribute("DLKPRICE")%></td>

			<td align="center"><form
					action="http://localhost:8080/web/kensyou" method="POST">
					<input type="submit" value="詳細3" name="syousai"></td>
		</tr>
		</form>

		<%
			}
		%>
		<%
			if (num == 4) {
		%>
		<th>検索結果はありませんでした</th>
		<%
			}
		%>
	</table>
</body>
</html>
