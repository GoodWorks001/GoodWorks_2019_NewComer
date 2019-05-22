<jsp:useBean id="shouhin" class="web.ProductBean" scope="session" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品紹介</title>
</head>


<!-- bodyを中央配置 -->
<body style="text-align:center;">



     <%--画像と在庫を取得し変数に代入 --%>
	<%
		String img = shouhin.getImg();
		int stock = shouhin.getStock();
	%>



	<!-- タイトル文字 -->
	<image src=<%=img%> align="left">
	<h1>
		<p align="center">商品紹介</p>
	</h1>




    <!-- 表の指定 -->
	<table border="1" width="500" cellspacing="0" cellpadding="5"
		bordercolor="black">
		<tr>
			<td>商品名</td>
			<td><jsp:getProperty property="name" name="shouhin" /></td>
		</tr>

		<tr>
			<td>カテゴリ</td>
			<td><jsp:getProperty property="category" name="shouhin" /></td>
		</tr>

		<tr>
			<td>価格</td>
			<td><jsp:getProperty property="price" name="shouhin" /></td>
		</tr>

		<tr>
			<td>在庫</td>
			<td><jsp:getProperty property="stock" name="shouhin" /></td>
		</tr>

		<tr>
			<td>商品紹介</td>
			<td><jsp:getProperty property="msg" name="shouhin" /></td>
		</tr>

	</table>


	<form action="http://localhost:8080/web/Cart" method="post">
	<%--在庫の個数をプルダウンで表示 --%>
		<div>
			個数 <select name="kosu">
				<%
					for (int k = 1; k <= stock; k++) {
				%>
				<option><%=k%></option>
				<%
					}
				%>
			</select>
		</div>

		<input type="submit" value="カートへ">
	</form>


	<form action="http://localhost:8080/web/Kensaku" method="post">
		<input type="submit" value="戻る">
	</form>
</body>
</html>