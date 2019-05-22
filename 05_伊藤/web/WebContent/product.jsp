<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品紹介</title>
</head>
<body>
	<%-- xmlに飛ばす --%>
	<form action="http://localhost:8080/web/Cart" method="post">
		<%
			String PASS = (String) request.getAttribute("img");
		%>

		<h1>商品紹介</h1>
		<img src=<%=PASS%> width="300" height="300">
		<table border=1 width=30%>
			<tr>
				<th>商品名</th>
				<td align="center">
					<%
						out.println(request.getAttribute("name1"));
					%>
				</td>
			</tr>
			<tr>
				<th>カテゴリ</th>
				<td align="center">
					<%
						out.println(request.getAttribute("cat_name"));
					%>
				</td>
			</tr>
			<tr>
				<th>価格</th>
				<td align="center">
					<%
						out.println(request.getAttribute("price"));
					%>
				</td>
			</tr>
			<tr>
				<th>在庫</th>
				<td align="center">
					<%
						out.println(request.getAttribute("stock"));
					%>
				</td>
			</tr>
			<tr>
				<th>商品紹介</th>
				<td align="center">
					<%
						out.println(request.getAttribute("msg"));
					%>
				</td>
			</tr>

		</table>
		<%
			String stock = (String) request.getAttribute("stock");
		%>
		<br>

		<th>個数</th> <select name="stock">
			<%-- 始めは表示しない --%>
			<%
				for (int i = 1; i <= Integer.parseInt(stock); i++) {
					out.println("<option value=" + i + ">" + i + "</option>");
			%>
			<%
				}
			%>
		</select>
		<button type="submit" name="cart" value="cart">カートへ</button>
		<button type="submit" name="back" value="back">戻る</button>
	</form>

</body>
</html>