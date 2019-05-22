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
	<br>
	<br>
	<p align="center">検索結果は0件でした</p>

</body>
</html>