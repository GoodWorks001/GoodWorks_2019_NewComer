<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- Bean使えるようにした--%>
<jsp:useBean id="syousai" class="ec.ProductBean" scope="session" />

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

	<body style="text-align: ">

		<%
			String img = syousai.getImg();
			int stock = syousai.getStock();
		%>

		<h1>
			<p align="center">商品紹介</p>
		</h1>


		<image src=<%=img%> align="left">
		<table border="1" width="500" cellspacing="0" cellpadding="5" bordercolor="black">
			<tr>
				<td>商品名</td>
				<td><jsp:getProperty property="name" name="syousai" /></td>
			</tr>
			<tr>
				<td>カテゴリ</td>
				<td><jsp:getProperty property="category" name="syousai" /></td>
			</tr>
			<tr>
				<td>価格</td>
				<td><jsp:getProperty property="price" name="syousai" /></td>
			</tr>
			<tr>
				<td>在庫</td>
				<td><jsp:getProperty property="stock" name="syousai" /></td>
			</tr>
			<tr>
				<td>商品紹介</td>
				<td><jsp:getProperty property="msg" name="syousai" /></td>
			</tr>
		</table>
		<form action="http://localhost:8080/ec/cart" method="POST">
		<div>
			個数<select name="kosu">
				<%
					for(int k =1;k<=stock;k++){
				%>
				<option><%=k%></option>
				<%
					}
				%>

			</select>
		</div>

		<input type="submit" value="カートへ">
		</form>

		<form action="kensaku.jsp">

		<input type="submit" value="戻る">

		</form>

	</body>

</html>