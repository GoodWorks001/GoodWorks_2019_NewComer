<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body "bgcolor="#99FFCC">
	<h1>
		<p align="center">カート</p>
	</h1>
	<br>

	<table border="1" width="500" cellspacing="0" align="center"
		cellpadding="5" bordercolor="black">
		<tr>
			<th>商品名</th>
			<th>単価</th>
			<th>数量</th>
		</tr>
		<%--各情報格納用配列を取り出す --%>
		<%
			ArrayList<String> Namelist = (ArrayList) session.getAttribute("cart");
		%>
		<%
			ArrayList<Integer> Kakakulist = (ArrayList) session.getAttribute("cart1");
		%>
		<%
			ArrayList<Integer> Kosulist = (ArrayList) session.getAttribute("cart2");
		%>
		<%--合計金額格納用変数の宣言 --%>
		<%
			int total = 0;
		%>
		<%--カート内情報の表示 --%>
		<%
			for (int i = 0; i < Namelist.size(); i++) {
		%>
		<tr>
			<td><%=Namelist.get(i)%></td>
			<td><%=Kakakulist.get(i)%></td>
			<td><%=Kosulist.get(i)%></td>
			<%--合計金額の計算 --%>
			<%
				total = total + Kakakulist.get(i) * Kosulist.get(i);
			%>
		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="2">消費税</td>
			<%--消費税を計算し表示 --%>
			<%
				int zei = (int) (total * 0.08);
			%>
			<td>\<%=zei%></td>
		</tr>
		<tr>
			<td colspan="2">合計金額</td>
			<%--込々の合計価格を表示 --%>
			<td>\<%=total + zei%></td>
		</tr>
	</table>
	<div align="center">
		<form action="Kensaku.jsp">
			<input type="submit" value="買い物を続ける">
		</form>

		<form action="Kounyuu.jsp">
			<input type="submit" value="購入">
		</form>
	</div>
</body>
</html>