<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索</title>
</head>
<body>

	<%-- xmlに飛ばす --%>
	<form action="http://localhost:8080/web/Search" method="post">



		<div align="center">
			<h1>検索</h1>
			<td><input type="text" name="search" size=60></td> <br>
			<br>


			<tr>カテゴリ
			</tr>
			<select name="category">

				<%-- 始めは表示しない --%>
				<option selected value="null"></option>
				<option value="1">生き物</option>
				<option value="2">乗り物</option>
			</select> <br>
			<br> <input type="submit" value="検索"> <br>
			<br>
	</form>


	<%
		String flg = (String) session.getAttribute("z");
	%>
	<form action="http://localhost:8080/web/Search" method="post">

		<%
			if (flg == "true") {
		%>
		<!-- まだリストを取得していないので何もしない -->
		<%
			} else {
		%>
		<!-- リスト取得 -->

		<%
			ArrayList<String> list = (ArrayList) session.getAttribute("list");
				if (list.size() != 0) {
		%>


		<table border="1">
			<tr>
				<td>商品名</td>

				<td>価格</td>

				<td>詳細</td>
			</tr>
			<%
				for (int i = 0; i < list.size(); i += 3) {
			%>

			<tr>
				<td><%=list.get(i)%></td>

				<td><%=list.get(i + 1)%></td>

				<td>

					<button type="submit" name="syousai" value="<%=list.get(i + 2)%>">詳細</button>
				</td>
			</tr>

			<%
				}
			%>
		</table>
		<%
			} else {
		%>
		<p>検索結果がありません</p>
		<%
			}
		%>
		<%
			}
		%>


	</form>
</body>
</html>