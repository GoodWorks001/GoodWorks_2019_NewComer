<%@ page language="java" contentType="text/html; charset=Windows-31J"
	import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�w���m�F</title>
</head>
<body>
	<script type="text/javascript">
		function btnLink() {
			location.href = "search.jsp"
		}
		function btnLink2() {
			location.href = "kanryou.jsp"
		}
	</script>
	<%
		ArrayList<Integer> listprice = (ArrayList<Integer>) session.getAttribute("cart_price");
		ArrayList<String> listname = (ArrayList<String>) session.getAttribute("cart_name");
		ArrayList<Integer> listorder = (ArrayList<Integer>) session.getAttribute("cart_order");
		int total = 0;
		int tax = 0;
	%>
	<h1 align="center">�w�����Ă�낵���ł��傤���H</h1>
	<form>
		<table border="1" width="500" cellspacing="0" align="center"
			cellpadding="5" bordercolor="black">
			<tr>
				<td>���i��</td>
				<td>�P��</td>
				<td>����</td>
			</tr>
			<%
				for (int i = 0; i < listname.size(); i++) {
			%>
			<tr height="40">
				<td><%=listname.get(i)%></td>
				<td>��<%=listprice.get(i)%></td>
				<td><%=listorder.get(i)%>
				    <% total += (listprice.get(i)*listorder.get(i)); %>
				</td>
			</tr>
			<%
				}
			%>
			<tr width="30">
				<td>�����</td>
				<td>��<% tax = (int)(total * 0.08); %>
				    <%= tax %>
				</td>
			</tr>
			<tr>
				<td>���v���z</td>
				<td>��<%=tax + total %></td>
			</tr>

		</table>
	</form>
	<br>
	<br>
	<form action="http://localhost:8080/EC/kakunin" method="POST">
		<table align="center">
			<tr>
				<td><button type="button" onclick="btnLink()">������</button></td>
				<td><input type="submit" value="�͂�"></td>
			</tr>
		</table>
	</form>

</body>
</html>