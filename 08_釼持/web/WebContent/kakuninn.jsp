<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=Windows-31J"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認</title>
</head>
<body>
	<%
		ArrayList<String> NList = (ArrayList) session.getAttribute("namesaigo");
		ArrayList<Integer> KList = (ArrayList) session.getAttribute("pricesaigo");
		ArrayList<Integer> SList = (ArrayList) session.getAttribute("kosuusaigo");
	%>
	<h1>
		<p align="center">購入してよろしいでしょうか？？</p>
	</h1>
	<br>

	<table border="1" width="500" cellspacing="0" align="center"
		cellpadding="5" bordercolor="black">
		<tr>
			<th>商品名</th>
			<th>単価</th>
			<th>数量</th>
		</tr>
		<%
			for (int i = 0; i < NList.size(); i++) {
		%>
		<tr>
			<td><%=NList.get(i)%></td>
			<td>\<%=KList.get(i)%></td>
			<td><%=SList.get(i)%></td>
		</tr>
		<%
			}
		%>
		<tr>
			<%
				int zei = 0;
			%>
			<%
				for (int i = 0; i < KList.size(); i++) {
					int a = 0;
					int b = 0;
					double c = 0.08;
					a += KList.get(i);
					b += SList.get(i);
			%>
			<%
				zei += (int) ((a * b) * c);
			%>
			<%
				}
			%>
			<th colspan="2">消費税
			</td>
			<td>\<%=zei%></td>

		</tr>
		<%
			int gou = 0;
		%>
		<%
			for (int i = 0; i < KList.size(); i++) {
				int a = 0;
				int b = 0;
				double d = 1.08;
				a += KList.get(i);
				b += SList.get(i);
		%>
		<%
			gou += (int) ((a * b) * d);
		%>
		<%
			}
		%>
		<tr>
			<th colspan="2">合計金額
			</td>
			<td>\<%=gou%></td>
		</tr>

	</table>
	<div align="center">
		<table>
			<tr>
				<td>
					<form action="http://localhost:8080/web/kensaku" method="POST">
						<input type="submit" value="いいえ">
					</form>
				</td>
				<td>
					<form action="http://localhost:8080/web/kanryou" method="POST">
						<input type="submit" value="はい">
					</form>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>