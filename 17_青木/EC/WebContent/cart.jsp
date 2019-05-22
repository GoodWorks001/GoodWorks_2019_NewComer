<%@ page language="java" contentType="text/html; charset=Windows-31J"
	import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート</title>
</head>
<body>
	<script type="text/javascript">
		function btnLink() {
			location.href = "search.jsp"
		}
		function btnLink2() {
			location.href = "kakunin.jsp"
		}
	</script>
	<%
		ArrayList<Integer> listprice = (ArrayList<Integer>) session.getAttribute("cart_price");
		ArrayList<String> listname = (ArrayList<String>) session.getAttribute("cart_name");
		ArrayList<Integer> listorder = (ArrayList<Integer>) session.getAttribute("cart_order");
		int total = 0;
		int tax = 0;
	%>
	<h1 align="center">カート</h1>
	<form>
		<table border="1" width="500" cellspacing="0" align="center"
			cellpadding="5" bordercolor="black">
			<tr>
				<td>商品名</td>
				<td>単価</td>
				<td>数量</td>
			</tr>
			<%
				for (int i = 0; i < listname.size(); i++) {
			%>
			<tr height="40">
				<td><%=listname.get(i)%></td>
				<td>￥<%=listprice.get(i)%></td>
				<td><%=listorder.get(i)%>
				    <% total += (listprice.get(i)*listorder.get(i)); %>
				</td>
			</tr>
			<%
				}
			%>
			<tr width="30">
				<td>消費税</td>
				<td>￥<% tax = (int)(total * 0.08); %>
				    <%= tax %>
				</td>
			</tr>
			<tr>
				<td>合計金額</td>
				<td>￥<%=tax + total %></td>
			</tr>

		</table>
	</form>
	<br>
	<br>
	<div align="center">
		<button type="button" onclick="btnLink()">買い物を続ける</button>
		<button type="button" onclick="btnLink2()">購入</button>
	</div>

</body>
</html>