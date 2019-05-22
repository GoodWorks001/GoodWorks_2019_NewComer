<%@ page language="java" contentType="text/html; charset=Windows-31J"
	import="java.util.ArrayList"%>
<jsp:useBean id="result" class="EC.SyouhinBean" scope="request" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>商品検索</title>
</head>
<body style="text-align: center;">
	<%
		ArrayList<Integer> listprice = (ArrayList<Integer>) session.getAttribute("price");
		ArrayList<String> listname = (ArrayList<String>) session.getAttribute("name");
		ArrayList<String> listcat = (ArrayList<String>) session.getAttribute("category");
		ArrayList<Integer> listcat_id = (ArrayList<Integer>) session.getAttribute("category_id");
	%>
	<h1>検索</h1>
	<form action="http://localhost:8080/EC/syouhin" method="POST">
		<input type="text" name="p_name"> <br> <br> <br>

		カテゴリ：

		<select name="category" size="1">
		    <option value= 0></option>
		    <%
			    for (int i = 0; i < listcat.size(); i++) {
		    %>
			    <option value=<%=listcat_id.get(i)%>><%=listcat.get(i)%></option>
			<%
			    }
		    %>
		</select>
 <br> <br>
		<!-- 送信ボタン -->
		<input type="submit" value="検索"> <br> <br>
	</form>
	<form action="http://localhost:8080/EC/syousai" method="POST">
		<table border="1" width="500" cellspacing="0" align="center"
			cellpadding="5" bordercolor="black">
			<tr>
				<td>商品名</td>
				<td>価格</td>
				<td>詳細</td>
			</tr>
			<%
				for (int i = 0; i < listname.size(); i++) {
			%>
			<tr height="40">
				<td><%=listname.get(i)%></td>
				<td>￥<%=listprice.get(i)%></td>
				<td><input type="hidden" name="syousai" value="<%=listname.get(i)%>">
					<input type="submit" value="詳細"></td>
			</tr>
			<%
				}
			%>
		</table>
	</form>
</body>
</html>