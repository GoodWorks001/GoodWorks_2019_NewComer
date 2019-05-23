<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>検索ページ</title>
</head>



<body style="text-algin: center">
	<div align="center">

		<%
			ArrayList<String> list = (ArrayList<String>) session.getAttribute("catgoryList");
		%>
		<h1>検索</h1>
		<br>
		<form action="http://localhost:8080/web/Kensaku" method="POST">
			<input type="text" name="search" size="55%"> <br> <br>
			<p>
				カテゴリ <select name="category">    <!-- categoryの中身を拡張for構文でだす -->
					<option value=""></option>
					<%
						int i = 1;
					%>
					<%
						for (String s : list) {
					%>

					<option value="<%=i%>"><%=s%></option>   <%--取得した値をだす --%>
					<%
						i = i + 1;
					%>
					<%
						}
					%>
				</select>
			</p>

			<input type="submit" value="検索">
		</form>


		<%
			String kanri = (String) session.getAttribute("flg");
		%>
		<%
			ArrayList<String> array = (ArrayList<String>) session.getAttribute("product");
		%>

        <%--arrayがnullじゃなかったらarrayの配列のサイズが0以上だったらif文 --%>

		<%
			if (array != null && array.size()>0) {
		%>
		<table border="1">
			<tr>
				<td>商品名</td>
				<td>価格</td>
				<td>詳細</td>
			</tr>


             <%--arrayの中を取得し該当の商品を探す --%>

			<%
				for (int x = 0; x < array.size(); x += 3) {
			%>
			<tr>
				<td><%=array.get(x)%></td>
				<td><%=array.get(x + 1)%></td>
				<td>
					<form action="http://localhost:8080/web/Shousai" method="POST">
						<input type="submit" value="詳細"> <input type="hidden"
							value="<%=array.get(x + 2)%>" name="id">
					</form>
				</td>
			</tr>
			<%
				}
			%>
		</table>

		<% }%>
		<br>


	</div>
</body>
</html>