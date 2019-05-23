<%@page import="org.apache.coyote.OutputBuffer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カート</title>
</head>
<body>

	<div align="center">
		<h1>カート</h1>
		<%
			ArrayList<String> names = (ArrayList<String>) session.getAttribute("name1");
			ArrayList<String> prices = (ArrayList<String>) session.getAttribute("price1");
			ArrayList<Integer> kosuus = (ArrayList<Integer>) session.getAttribute("kosuu1");

			int yen = 0, goukei = 0;
			double rate = 0.08;
		%>



		<table border=1 width=60%>
			<tr>
				<th>商品名</th>
				<th>単価</th>
				<th>数量</th>
			</tr>
			<%
				for (int i = 0; i < names.size(); i++) {
					out.println("<tr>");
					out.println("<td>" + names.get(i) + "</td>");
					out.println("<td>" + Integer.parseInt(prices.get(i)) + "</td>");
					out.println("<td>" + kosuus.get(i) + "</td>");
					out.println("</tr>");
				}
			%>
			<tr>
				<td colspan="2">消費税</td>
				<td>
					<%
						int price_zei = 0;
						for (int i = 0; i < prices.size(); i++) {
							for (int j = 0; j < kosuus.get(i); j++) {
								yen = (int) ((Integer.parseInt(prices.get(i))) * rate);
								price_zei += yen;
							}
						}
						out.println(price_zei);
					%>
				</td>
			</tr>
			<tr>
				<td colspan="2">合計金額</td>
				<td>
					<%
						int price_goukei = 0;
						for (int i = 0; i < prices.size(); i++) {
							for (int j = 0; j < kosuus.get(i); j++) {
								goukei = (int) ((Integer.parseInt(prices.get(i))) * (rate + 1.00));
								price_goukei += goukei;
							}
						}
						out.println(price_goukei);
					%>
				</td>
			</tr>

		</table>
	</div>
	<%-- xmlに飛ばす --%>
	<form action="http://localhost:8080/web/Buy" method="post">
		<table align="center">
			<tr>
				<td>
					<button type="submit" name="next" value="next">購入</button>
				</td>
				<td>
					<button type="submit" name="back" value="back">買い物を続ける</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>