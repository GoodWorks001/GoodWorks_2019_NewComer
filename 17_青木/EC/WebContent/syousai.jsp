<%@ page language="java" contentType="text/html; charset=Windows-31J"
	import="java.util.ArrayList"%>
<!DOCTYPE html>
<jsp:useBean id="Item" class="EC.SyouhinBean" scope="session" />
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
</head>
<body>
	<%
		int stock = Item.getStock();
		int price = Item.getPrice();
		String pro_name = Item.getName();
	%>
	<h1 align="center">商品詳細</h1>

	<script type="text/javascript">
		function btnLink() {
			location.href = "search.jsp"
		}
	</script>



	<img src="<jsp:getProperty name="Item" property="img"/>" align="left"
		width="500" height="400">
	<table>
		<tr>
			<td><table border="1" width="300" cellspacing="0" align="center"
					cellpadding="5" bordercolor="black">
					<tr>
						<td>商品名</td>
						<td><jsp:getProperty name="Item" property="name" /></td>
					</tr>
					<tr>
						<td>カテゴリ</td>
						<td><jsp:getProperty name="Item" property="cat_name" /></td>
					</tr>
					<tr>
						<td>価格</td>
						<td>￥<jsp:getProperty name="Item" property="price" /></td>
					</tr>
					<tr>
						<td>在庫</td>
						<td><jsp:getProperty name="Item" property="stock" /></td>
					</tr>
					<tr>
						<td>商品紹介</td>
						<td><jsp:getProperty name="Item" property="msg" /></td>
					</tr>
				</table></td>
		</tr>
	</table>
	<form action="http://localhost:8080/EC/cart" method="POST">
		個数：<select name="order" size="1">
			<%
				for (int i = 1; i <= stock; i++) {
			%>
			<option value=<%=i%>><%=i%></option>
			<%
				}
			%>
		</select>
		<!-- 送信ボタン -->
		<input type="hidden" name="price" value="<%=price%>"> <input
			type="hidden" name="pro_name" value="<%=pro_name%>"> <input
			type="submit" value="カートへ">
	</form>
	<!-- 送信ボタン -->
	<button type="button" onclick="btnLink()">戻る</button>

</body>
</html>