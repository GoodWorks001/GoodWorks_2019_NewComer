<%@ page language="java" contentType="text/html; charset=Windows-31J"
	import="java.util.ArrayList"%>
<!DOCTYPE html>
<jsp:useBean id="Item" class="EC.SyouhinBean" scope="session" />
<html>
<head>
<meta charset="UTF-8">
<title>���i�ڍ�</title>
</head>
<body>
	<%
		int stock = Item.getStock();
		int price = Item.getPrice();
		String pro_name = Item.getName();
	%>
	<h1 align="center">���i�ڍ�</h1>

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
						<td>���i��</td>
						<td><jsp:getProperty name="Item" property="name" /></td>
					</tr>
					<tr>
						<td>�J�e�S��</td>
						<td><jsp:getProperty name="Item" property="cat_name" /></td>
					</tr>
					<tr>
						<td>���i</td>
						<td>��<jsp:getProperty name="Item" property="price" /></td>
					</tr>
					<tr>
						<td>�݌�</td>
						<td><jsp:getProperty name="Item" property="stock" /></td>
					</tr>
					<tr>
						<td>���i�Љ�</td>
						<td><jsp:getProperty name="Item" property="msg" /></td>
					</tr>
				</table></td>
		</tr>
	</table>
	<form action="http://localhost:8080/EC/cart" method="POST">
		���F<select name="order" size="1">
			<%
				for (int i = 1; i <= stock; i++) {
			%>
			<option value=<%=i%>><%=i%></option>
			<%
				}
			%>
		</select>
		<!-- ���M�{�^�� -->
		<input type="hidden" name="price" value="<%=price%>"> <input
			type="hidden" name="pro_name" value="<%=pro_name%>"> <input
			type="submit" value="�J�[�g��">
	</form>
	<!-- ���M�{�^�� -->
	<button type="button" onclick="btnLink()">�߂�</button>

</body>
</html>