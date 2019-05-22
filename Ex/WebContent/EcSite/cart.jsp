<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート画面</title>
</head>
<body>
<h3 align="right"><%="ログイン中：" + session.getAttribute("login_name")%></h3>
	<%
		NumberFormat nfCur = NumberFormat.getCurrencyInstance();

		ArrayList<String> names = (ArrayList<String>) session.getAttribute("names");
		ArrayList<String> prices = (ArrayList<String>) session.getAttribute("prices");
		ArrayList<Integer> kosuus = (ArrayList<Integer>) session.getAttribute("kosuus");

		int yen = 0, goukei = 0;
		double rate = 0.08;
	%>
	<h1>
		<p align="center">カート</p>
	</h1>
	<br>
	<table border="1" width="500" cellspacing="0" align="center"
		cellpadding="5" bordercolor="black">
		<tr>
			<td><b>商品名</b></td>
			<td><b>単価</b></td>
			<td><b>数量</b></td>
		</tr>
		<%
			for (int i = 0; i < names.size(); i++) {
				out.println("<tr>");
				out.println("<td>" + names.get(i) + "</td>");
				out.println("<td>" + nfCur.format(Integer.parseInt((prices.get(i)))) + "</td>");
				out.println("<td>" + kosuus.get(i) + "</td>");
				out.println("</tr>");
			}
		%>
		<tr>
			<td colspan="2"><b>消費税</b></td>
			<td>
				<%
					int price_zei = 0;
					for (int i = 0; i < prices.size(); i++) {
						for (int j = 0; j < kosuus.get(i); j++) {
							yen = (int) ((Integer.parseInt(prices.get(i))) * rate);
							price_zei += yen;
						}
					}
					out.println(nfCur.format(price_zei));
				%>
			</td>
		</tr>
		<tr>
			<td colspan="2"><b>合計金額</b></td>
			<td>
				<%
					int price_goukei = 0;
					for (int i = 0; i < prices.size(); i++) {
						for (int j = 0; j < kosuus.get(i); j++) {
							goukei = (int) ((Integer.parseInt(prices.get(i))) * (rate + 1.00));
							price_goukei += goukei;
						}
					}
					out.println(nfCur.format(price_goukei));
				%>
			</td>
		</tr>
	</table>
	<form action="/Ex/cart" method="post">
		<div align="center">
			<table>
				<tr>
					<td><button type="submit" name="back" value="back">買い物を続ける</button></td>
					<td><button type="submit" name="next" value="next">購入</button></td>
				</tr>
			</table>
		</div>
	</form>

</body>
</html>