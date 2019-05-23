<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body  style="text-align:center;"bgcolor="#99FFCC">
<form action = "http://localhost:8080/iyada/kensakuServlet" method = "post">
<h1>検索画面</h1><br>
<br>
<input type = "text" name = "ken"><br>
<br>
カテゴリ
<%--検索内容の取得 --%>
<% ArrayList<String> cat = (ArrayList)session.getAttribute("cattt"); %>
<%--カテゴリを表示 --%>
<select name="category" align="center">
	<option value="0"></option>
	<%for(int i = 0; i< cat.size(); i++){ %>
	<option value="<%=i + 1%>"><%=cat.get(i) %></option>
	<%} %>

</select><br>
<br>
<input type = "submit" value = "検索">
</form>
<br>
<% String syouhin = (String)session.getAttribute("syouhin"); %>
	<% if(syouhin == "null"){ %>
<!-- 		何もしないよ -->
	<%}else{ %>
		<%--商品情報をテーブル形式で表示するための取得 --%>
		<% ArrayList<String> list = (ArrayList)session.getAttribute("list"); %>
		<table border="1" width="500" cellspacing="0" cellpadding="5" bordercolor="black" align="center">
			<tr>
				<td>
					商品名
				</td>
				<td>
					価格
				</td>
				<td>
					詳細
				</td>
			</tr>
		<%--商品情報を画面に表示する為のループ --%>
		<% for(int i = 0; i < list.size(); i += 3){ %>
		<form action = "http://localhost:8080/iyada/syousaiServlet" method = "post">
			<tr>
				<td>
					<%=list.get(i) %>
				</td>
				<td>
					<%=list.get(i + 1) %>
				</td>
				<td>
					<input type = "submit" value = "詳細">
					<input type = "hidden" value = "<%=list.get(i+2) %>" name = "cod">
				</td>
			</tr>
		</form>
		<% } %>
	<%} %>

</table>

</body>
</html>